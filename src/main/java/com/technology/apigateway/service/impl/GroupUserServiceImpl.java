package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.GroupUserRequest;
import com.technology.apigateway.database.entity.GroupUser;
import com.technology.apigateway.database.entity.GroupUserStatus;
import com.technology.apigateway.database.repository.GroupUserRepository;
import com.technology.apigateway.database.repository.GroupUserStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("groupUserService")
public class GroupUserServiceImpl implements GroupUserService {

    @Autowired
    GroupUserRepository groupUserRepository;

    @Autowired
    GroupUserStatusRepository groupUserStatusRepository;

    @Override
    public GroupUserStatus createGroupUser(GroupUserRequest groupUserRequest) {
        GroupUserStatus groupUserStatus;
        try {
            groupUserStatus = groupUserStatusRepository.createGroupUser(
                    groupUserRequest.getName(),
                    groupUserRequest.getRegion(),
                    groupUserRequest.getArea(),
                    groupUserRequest.getBranch(),
                    groupUserRequest.getRole(),
                    groupUserRequest.getGfId(),
                    groupUserRequest.getDescription());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return groupUserStatus;
    }

    @Override
    public List<GroupUserRequest> getAllGroupUser() {
        List<GroupUser> groupUserList = groupUserRepository.getAllGroupUser();
        if (groupUserList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Group User");
        }
        List<GroupUserRequest> groupUserRequestList = new ArrayList<>();
        for (GroupUser groupUser : groupUserList) {
            GroupUserRequest groupUserRequest = new GroupUserRequest();
            groupUserRequest.setGid(groupUser.getGid());
            groupUserRequest.setName(groupUser.getName());
            groupUserRequest.setRegion(groupUser.getRegion());
            groupUserRequest.setArea(groupUser.getArea());
            groupUserRequest.setBranch(groupUser.getBranch());
            groupUserRequest.setRole(groupUser.getRole());
            groupUserRequest.setGfId(groupUser.getGfId());
            groupUserRequest.setDescription(groupUser.getDescription());
            groupUserRequest.setCreatedDate(groupUser.getCreatedDate());
            groupUserRequest.setStatus(groupUser.getStatus());
            groupUserRequestList.add(groupUserRequest);
        }
        return groupUserRequestList;
    }
}
