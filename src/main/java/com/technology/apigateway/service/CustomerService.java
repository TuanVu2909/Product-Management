package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.CustomerRequest;
import com.technology.apigateway.controller.request.GetCustomerRequest;
import com.technology.apigateway.controller.request.GetIncomeCustomerByIdAndIncomeType;
import com.technology.apigateway.database.entity.*;
import com.technology.apigateway.database.entity.status.CustomerStatus;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    List<CustomerRequest> getAllCustomer();

    List<Customer> getCustomerWhere(GetCustomerRequest request);

    CustomerStatus createCustomer(CustomerRequest customerRequest);

    CustomerStatus updateCustomer(CustomerRequest customerRequest);

    List<IncomeEntity> getIncomesByUserId(GetCustomerRequest request);

    List<GuardiansEntity> getGuardiansByUserId(GetCustomerRequest request);

    List<ReferencesEntity> getReferencesByUserId(GetCustomerRequest request);

    List<ReferencesEntity> getReferencesByRegId(GetCustomerRequest request);

    List<IncomeEntity> getCustomerByIdAndIncomeType(GetIncomeCustomerByIdAndIncomeType request);

    UserScoring getScoring(int userId);

    Scoring getScoringCal(int userId);

    List<SimilarAssets> getSameAssets(int userId);

    List<UserFile> getUserFile(Integer custId) throws IOException;

    List<UserFile> getUserFileByRegId(Integer regId) throws IOException;

    List<ListCustomerBalance> getListCustomerBalance();

    List<ListCustomerTransaction> getListTransaction();

}
