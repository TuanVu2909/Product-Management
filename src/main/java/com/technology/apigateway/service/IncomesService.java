package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.incomes.CreateIncomesRequest;
import com.technology.apigateway.controller.request.incomes.UpdateIncomesRequest;
import com.technology.apigateway.database.entity.status.CustomerStatus;
import com.technology.apigateway.database.entity.IncomeEntity;

public interface IncomesService {

    CustomerStatus createIncomes(CreateIncomesRequest createIncomesRequest);

    CustomerStatus updateIncomes(UpdateIncomesRequest updateIncomesRequest);

    IncomeEntity deleteIncomesById(int id);

}
