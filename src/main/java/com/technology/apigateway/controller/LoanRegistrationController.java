package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.LoanRegistrationRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.LoanRegistrationService;
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
public class LoanRegistrationController extends BaseResponse<LoanService> {
    @Autowired
    LoanRegistrationService loanRegistrationService;

    // lay chi tiet ho so vay
    @PostMapping("get-loan-registration")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getLoanRegistration(HttpServletRequest httpServletRequest,
            @RequestBody LoanRegistrationRequest loanRegistrationRequest) {
        return response(toResult(loanRegistrationService.getLoanRegistration(loanRegistrationRequest)));
    }

    @PostMapping("get-list-loan-registration")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllLoanRegistrationWhere(HttpServletRequest httpServletRequest,
            @RequestBody LoanRegistrationRequest request) {
        return response(toResult(loanRegistrationService.getListLoanRegistration(request)));
    }

    @PostMapping("create-loan-registration")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createLoanRegistration(HttpServletRequest httpServletRequest,
            @RequestBody LoanRegistrationRequest loanRegistrationRequest) {
        return response(toResult(loanRegistrationService.createLoanRegistration(loanRegistrationRequest)));
    }

    @PostMapping("update-loan-registration")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateLoanRegistration(HttpServletRequest httpServletRequest,
            @RequestBody LoanRegistrationRequest loanRegistrationRequest) {
        return response(toResult(loanRegistrationService.updateLoanRegistration(loanRegistrationRequest)));
    }

    @PostMapping("update-loanreg-status")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateLoanRegStatus(HttpServletRequest httpServletRequest,
            @RequestBody LoanRegistrationRequest loanRegistrationRequest) {
        return response(toResult(loanRegistrationService.updateLoanRegistrationStatus(loanRegistrationRequest)));
    }

}
