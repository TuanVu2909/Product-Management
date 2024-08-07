package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.incomes.UpdateIncomesRequest;
import com.technology.apigateway.database.entity.CustomerStatus;

public interface IncomesService {

    CustomerStatus updateIncomes(UpdateIncomesRequest updateIncomesRequest);

}
