package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.CustomerCareRequest;
import com.technology.apigateway.database.entity.CustomerCare;
import com.technology.apigateway.database.entity.status.CustomerCareStatus;
import com.technology.apigateway.database.repository.CustomerCareRepository;
import com.technology.apigateway.database.repository.CustomerCareStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.CustomerCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customerCareService")
public class CustomerCareServiceImpl implements CustomerCareService {

    @Autowired
    CustomerCareStatusRepository customerCareStatusRepository;

    @Autowired
    CustomerCareRepository customerCareRepository;

    @Override
    public List<CustomerCareRequest> getAllCustomerCare() {
        List<CustomerCare> customerCareList = customerCareRepository.getAllCustomerCare();
        if (customerCareList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Customer Care");
        }
        List<CustomerCareRequest> customerCareRequestList = new ArrayList<>();
        for (CustomerCare customerCare : customerCareList) {
            CustomerCareRequest customerCareRequest = new CustomerCareRequest();
            customerCareRequest.setId(customerCare.getId());
            customerCareRequest.setCustId(customerCare.getCustId());
            customerCareRequest.setCareId(customerCare.getCareId());
            customerCareRequest.setCareType(customerCare.getCareType());
            customerCareRequest.setCreatedDate(customerCare.getCreatedDate());
            customerCareRequestList.add(customerCareRequest);
        }
        return customerCareRequestList;
    }

    @Override
    public CustomerCareStatus createCustomerCare(CustomerCareRequest customerCareRequest) {
        CustomerCareStatus customerCareStatus;
        try {
            customerCareStatus = customerCareStatusRepository.createCustomerCare(
                    customerCareRequest.getCustId(),
                    customerCareRequest.getCareId(),
                    customerCareRequest.getCareType());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerCareStatus;
    }

    @Override
    public CustomerCareStatus updateCustomerCare(CustomerCareRequest customerCareRequest) {
        CustomerCareStatus customerCareStatus;
        try {
            customerCareStatus = customerCareStatusRepository.updateCustomerCare(
                    customerCareRequest.getId(),
                    customerCareRequest.getCustId(),
                    customerCareRequest.getCareId(),
                    customerCareRequest.getCareType(),
                    customerCareRequest.getCreatedDate()
            );
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerCareStatus;
    }
}
