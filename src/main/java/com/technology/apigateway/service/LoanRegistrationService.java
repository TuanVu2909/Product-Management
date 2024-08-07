package com.technology.apigateway.service;

import java.util.List;

import com.technology.apigateway.controller.request.LoanRegistrationRequest;
import com.technology.apigateway.database.entity.ListLoanRegistration;
import com.technology.apigateway.database.entity.LoanRegistrationStatus;

public interface LoanRegistrationService {

    List<ListLoanRegistration> getLoanRegistration(LoanRegistrationRequest loanRegistrationRequest);

    // List<LoanRegistrationRequest> getLoanRegistrationByCustId(int cust);

    List<ListLoanRegistration> getListLoanRegistration(LoanRegistrationRequest request);

    LoanRegistrationStatus createLoanRegistration(LoanRegistrationRequest loanRegistrationRequest);

    LoanRegistrationStatus updateLoanRegistration(LoanRegistrationRequest loanRegistrationRequest);

    LoanRegistrationStatus updateLoanRegistrationStatus(LoanRegistrationRequest loanRegistrationRequest);
}
