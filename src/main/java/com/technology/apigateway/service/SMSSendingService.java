package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.SMSSendingRequest;

public interface SMSSendingService {
    Object callSMSSendingAPI(SMSSendingRequest request);
}
