package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.GroupFunctionRequest;
import com.technology.apigateway.database.entity.status.GroupFunctionStatus;
import com.technology.apigateway.models.GroupFunctionModel;

import java.util.List;

public interface GroupFunctionService {

    List<GroupFunctionModel> getGroupFunction();

    GroupFunctionStatus createGroupFunction(GroupFunctionRequest groupFunctionRequest);
}
