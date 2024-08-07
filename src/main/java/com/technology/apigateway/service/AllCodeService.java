package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.AllCodeRequest;

import java.util.List;

public interface AllCodeService {

    List<AllCodeRequest> getAllAllCode();

    List<AllCodeRequest> getAllCodeByType(String type);
}
