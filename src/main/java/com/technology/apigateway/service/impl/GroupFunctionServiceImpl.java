package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.GroupFunctionRequest;
import com.technology.apigateway.database.entity.Function;
import com.technology.apigateway.database.entity.GroupFunction;
import com.technology.apigateway.database.entity.GroupFunctionStatus;
import com.technology.apigateway.database.repository.FunctionRepository;
import com.technology.apigateway.database.repository.GroupFunctionRepository;
import com.technology.apigateway.database.repository.GroupFunctionStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.models.FunctionModel;
import com.technology.apigateway.models.GroupFunctionModel;
import com.technology.apigateway.service.GroupFunctionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("groupFunctionService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupFunctionServiceImpl implements GroupFunctionService {

    GroupFunctionRepository groupFunctionRepository;

    FunctionRepository allFunctionRepository;

    GroupFunctionStatusRepository groupFunctionStatusRepository;

    @Override
    public List<GroupFunctionModel> getGroupFunction() {
        // Create a mock user object
        List<GroupFunction> lstGrpFunctions = new ArrayList<GroupFunction>();
        List<Function> lAllFunctions = new ArrayList<Function>();
        lstGrpFunctions = groupFunctionRepository.getAllGroupFunction();
        lAllFunctions = allFunctionRepository.getAllFunction();

        // Set all value to new group function model
        List<GroupFunctionModel> grpFunction = new ArrayList<>();
        // Each group function from database set to new group function model
        for (GroupFunction groupFunctionEntity : lstGrpFunctions) {
            GroupFunctionModel groupFunctionModel = new GroupFunctionModel(); // New group function model
            List<FunctionModel> lstFunction = new ArrayList<>(); // New list function by each group function model
            String[] lstFunctionByString = groupFunctionEntity.getFunctions().split(","); // Split value function

            // Find function by function id
            for (String stringFunction : lstFunctionByString) {
                lAllFunctions.forEach((t) -> {
                    if (t.getFunctionId().equals(stringFunction.trim())) {
                        FunctionModel function = new FunctionModel(); // New function model
                        function.setFunctionId(t.getFunctionId());
                        function.setFunctionName(t.getFunctionName());
                        function.setGroupFunctionId(groupFunctionEntity.getGfId());
                        lstFunction.add(function); // Add to list function
                    }
                });
            }
            // Set to new group function model
            groupFunctionModel.setGroupId(groupFunctionEntity.getGfId());
            groupFunctionModel.setGroupName(groupFunctionEntity.getName());
            groupFunctionModel.setLstFunctions(lstFunction);
            grpFunction.add(groupFunctionModel);

        }
        return grpFunction;
    }

    @Override
    public GroupFunctionStatus createGroupFunction(GroupFunctionRequest groupFunctionRequest) {
        GroupFunctionStatus groupFunctionStatus;
        try {
            groupFunctionStatus = groupFunctionStatusRepository.createGroupFunction(
                    groupFunctionRequest.getName(),
                    groupFunctionRequest.getFunctions());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return groupFunctionStatus;
    }
}
