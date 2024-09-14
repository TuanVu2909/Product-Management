package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.incomes.CreateIncomesRequest;
import com.technology.apigateway.controller.request.incomes.UpdateIncomesRequest;
import com.technology.apigateway.database.entity.status.CustomerStatus;
import com.technology.apigateway.database.entity.IncomeEntity;
import com.technology.apigateway.database.repository.CustomerStatusRepository;
import com.technology.apigateway.database.repository.IncomeRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.IncomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("incomesService")
public class IncomesServiceImpl implements IncomesService {

    @Autowired
    CustomerStatusRepository customerStatusRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public CustomerStatus createIncomes(CreateIncomesRequest createIncomesRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.createIncomes(
                    createIncomesRequest.getUserId(),
                    createIncomesRequest.getCompanyName(),
                    createIncomesRequest.getCompanyAddress(),
                    createIncomesRequest.getJobTitle(),
                    createIncomesRequest.getSalary(),
                    createIncomesRequest.getCreditInsName(),
                    createIncomesRequest.getMonth(),
                    createIncomesRequest.getPrincipalPerMonth(),
                    createIncomesRequest.getInterestPerMonth(),
                    createIncomesRequest.getTotalPerMonth(),
                    createIncomesRequest.getIncomeType());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

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

    @Override
    public IncomeEntity deleteIncomesById(int id) {
        incomeRepository.deleteById(id);
        return null;
    }
}
