package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.LoanLimitRequest;
import com.technology.apigateway.database.entity.ListLoanLimit;
import com.technology.apigateway.database.entity.LoanLimitStatus;

import java.util.List;

public interface LoanLimitService {

    LoanLimitStatus createLoanLimit(LoanLimitRequest loanLimitRequest);

    List<ListLoanLimit> getListLoanLimit(LoanLimitRequest loanLimitRequest);


}
