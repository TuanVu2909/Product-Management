package com.technology.apigateway.service;

import java.util.List;

import com.technology.apigateway.controller.request.LoanRegistrationRequest;
import com.technology.apigateway.database.entity.ListLoanRegistration;
import com.technology.apigateway.database.entity.status.LoanRegistrationStatus;

public interface LoanRegistrationService {

    List<ListLoanRegistration> getLoanRegistration(LoanRegistrationRequest loanRegistrationRequest);

    List<ListLoanRegistration> getListLoanRegistration(LoanRegistrationRequest request);

    LoanRegistrationStatus createLoanRegistration(LoanRegistrationRequest loanRegistrationRequest);

    LoanRegistrationStatus updateLoanRegistration(LoanRegistrationRequest loanRegistrationRequest);

    LoanRegistrationStatus updateLoanRegistrationStatus(LoanRegistrationRequest loanRegistrationRequest);
}
