package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.LoanScheduleRequest;
import com.technology.apigateway.controller.request.OperatorLoanScheduleRequest;
import com.technology.apigateway.database.entity.OperatorLoanSchedule;

import java.util.List;

public interface LoanScheduleService {

    List<LoanScheduleRequest> getLoanScheduleByLoanId(int loanId);

    List<OperatorLoanSchedule> operatorLoanSchedule(OperatorLoanScheduleRequest loanScheduleRequest);

}
