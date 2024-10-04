package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.LoanRequest;
import com.technology.apigateway.controller.request.OperatorLoanRequest;
import com.technology.apigateway.controller.request.payment.ApprovePrePaymentRequest;
import com.technology.apigateway.controller.request.payment.PrePaymentRequest;
import com.technology.apigateway.database.entity.ListLoan;
import com.technology.apigateway.database.entity.LoanStatus;
import com.technology.apigateway.database.entity.OperatorLoan;

import java.util.List;

public interface LoanService {

    LoanStatus createLoan(LoanRequest loanRequest);

    LoanStatus updateLoanStatus(LoanRequest loanRequest);

    LoanStatus prePayment(PrePaymentRequest request);

    LoanStatus approvePrePayment(ApprovePrePaymentRequest request);

    List<ListLoan> getLoanList(LoanRequest loanRequest);

    List<OperatorLoan> operatorLoan(OperatorLoanRequest operatorLoanRequest);
}
