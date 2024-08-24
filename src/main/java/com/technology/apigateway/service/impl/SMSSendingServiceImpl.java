package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.Constants;
import com.technology.apigateway.controller.request.SMSSendingRequest;
import com.technology.apigateway.service.SMSSendingService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SMSSendingServiceImpl implements SMSSendingService {

    private final RestTemplate restTemplate;

    public SMSSendingServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.basicAuthentication(Constants.SOUTH_TELECOM_SMS_API_USER,
                Constants.SOUTH_TELECOM_SMS_API_PASSWORD).build();
    }

    public Object callSMSSendingAPI(SMSSendingRequest request) {

        try {
            String uri = Constants.SOUTH_TELECOM_SMS_API_URI_1;
            return restTemplate.postForObject(uri, request, Object.class);
        } catch (Exception ignored) {
            String uri = Constants.SOUTH_TELECOM_SMS_API_URI_2;
            return restTemplate.postForObject(uri, request, Object.class);
        }
    }
}
