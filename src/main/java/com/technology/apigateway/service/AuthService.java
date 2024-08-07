package com.technology.apigateway.service;

import java.util.Map;

import com.technology.apigateway.controller.request.LoginRequest;
import com.technology.apigateway.database.entity.User;

public interface AuthService {

    public Map<String, Object> login(LoginRequest loginRequest);

    public User getUser();
}
