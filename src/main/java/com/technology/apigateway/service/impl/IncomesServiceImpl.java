package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.incomes.UpdateIncomesRequest;
import com.technology.apigateway.database.entity.CustomerStatus;
import com.technology.apigateway.database.repository.CustomerStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.IncomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("incomesService")
public class IncomesServiceImpl implements IncomesService {

    @Autowired
    CustomerStatusRepository customerStatusRepository;

    @Override
    public CustomerStatus updateIncomes(UpdateIncomesRequest updateIncomesRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.updateIncomes(
                    updateIncomesRequest.getId(),
                    updateIncomesRequest.getUserId(),
                    updateIncomesRequest.getCompanyName(),
                    updateIncomesRequest.getCompanyAddress(),
                    updateIncomesRequest.getJobTitle(),
                    updateIncomesRequest.getSalary(),
                    updateIncomesRequest.getCreditInsName(),
                    updateIncomesRequest.getMonth(),
                    updateIncomesRequest.getPrincipalPerMonth(),
                    updateIncomesRequest.getInterestPerMonth(),
                    updateIncomesRequest.getTotalPerMonth(),
                    updateIncomesRequest.getIncomeType());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }
}
