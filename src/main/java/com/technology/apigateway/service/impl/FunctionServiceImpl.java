package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.FunctionRequest;
import com.technology.apigateway.database.entity.Function;
import com.technology.apigateway.database.repository.FunctionRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    @Override
    public List<FunctionRequest> getAllFunction() {
        List<Function> functionList = functionRepository.getAllFunction();
        if (functionList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Function");
        }
        List<FunctionRequest> functionRequestList = new ArrayList<>();
        for (Function function : functionList) {
            FunctionRequest functionRequest = new FunctionRequest();
            functionRequest.setFunctionId(function.getFunctionId());
            functionRequest.setFunctionName(function.getFunctionName());
            functionRequest.setStatus(function.getStatus());
            functionRequestList.add(functionRequest);
        }
        return functionRequestList;
    }
}
