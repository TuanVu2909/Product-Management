package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.SMSSendingRequest;
import com.technology.apigateway.database.entity.SMSEntity;

import java.util.List;

public interface SMSSendingService {

    Object callSMSSendingAPI(SMSSendingRequest request);

    List<SMSEntity> getFindSMSByMobile();

    List<SMSEntity> getLogs();

}
