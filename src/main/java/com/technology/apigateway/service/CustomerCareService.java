package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.CustomerCareRequest;
import com.technology.apigateway.database.entity.status.CustomerCareStatus;

import java.util.List;

public interface CustomerCareService {

    List<CustomerCareRequest> getAllCustomerCare();
    CustomerCareStatus createCustomerCare(CustomerCareRequest customerCareRequest);

    CustomerCareStatus updateCustomerCare(CustomerCareRequest customerCareRequest);

}
