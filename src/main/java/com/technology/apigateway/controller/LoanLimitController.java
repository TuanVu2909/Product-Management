package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.LoanLimitRequest;
import com.technology.apigateway.controller.request.LoanRequest;
import com.technology.apigateway.controller.request.OperatorLoanRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.LoanLimitService;
import com.technology.apigateway.service.LoanService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "https://apigateway.lendbiz.vn", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Log4j2
public class LoanLimitController extends BaseResponse {
    @Autowired
    LoanLimitService loanLimitService;

    @Autowired
    LoanService loanService;

    @PostMapping("create-loan-limit")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createLoanLimit(HttpServletRequest httpServletRequest,
                                             @RequestBody LoanLimitRequest loanLimitRequest) {
        return response(toResult(loanLimitService.createLoanLimit(loanLimitRequest)));
    }

    @PostMapping("create-loan")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createLoan(HttpServletRequest httpServletRequest,
                                        @RequestBody LoanRequest loanRequest) {
        return response(toResult(loanService.createLoan(loanRequest)));
    }

    @PostMapping("update-loan-status")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateLoanStatus(HttpServletRequest httpServletRequest,
                                              @RequestBody LoanRequest loanRequest) {
        return response(toResult(loanService.updateLoanStatus(loanRequest)));
    }

    @PostMapping("get-list-loan-limit")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getListLoanLimit(HttpServletRequest httpServletRequest,
                                              @RequestBody LoanLimitRequest loanLimitRequest) {
        return response(toResult(loanLimitService.getListLoanLimit(loanLimitRequest)));
    }

    @PostMapping("get-loan-list")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getLoanList(HttpServletRequest httpServletRequest,
                                         @RequestBody LoanRequest loanRequest) {
        return response(toResult(loanService.getLoanList(loanRequest)));
    }

    @PostMapping("pre-payment")
    @Transactional(readOnly = true)
    public ResponseEntity<?> prePayment(HttpServletRequest httpServletRequest,
                                        @RequestBody LoanRequest loanRequest) {
        return response(toResult(loanService.prePayment(loanRequest)));
    }

    @PostMapping("operator-loan")
    @Transactional(readOnly = true)
    public ResponseEntity<?> operatorLoan(HttpServletRequest httpServletRequest,
                                          @RequestBody OperatorLoanRequest operatorLoanRequest) {
        return response(toResult(loanService.operatorLoan(operatorLoanRequest)));

    }
}
