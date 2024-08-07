package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.FunctionRequest;

import java.util.List;

public interface FunctionService {

    List<FunctionRequest> getAllFunction();

    //FunctionRequest getFunctionByUserId(String userId);


}
