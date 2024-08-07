package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.GroupUserRequest;
import com.technology.apigateway.database.entity.GroupUser;
import com.technology.apigateway.database.entity.GroupUserStatus;

import java.util.List;

public interface GroupUserService {
    GroupUserStatus createGroupUser(GroupUserRequest groupUserRequest);

    List<GroupUserRequest> getAllGroupUser();
}
