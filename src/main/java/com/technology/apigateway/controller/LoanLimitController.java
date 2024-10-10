package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.LoanDetailRequest;
import com.technology.apigateway.controller.request.LoanLimitRequest;
import com.technology.apigateway.controller.request.LoanRequest;
import com.technology.apigateway.controller.request.OperatorLoanRequest;
import com.technology.apigateway.controller.request.payment.ApprovePrePaymentRequest;
import com.technology.apigateway.controller.request.payment.PrePaymentRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.LoanDetailService;
import com.technology.apigateway.service.LoanLimitService;
import com.technology.apigateway.service.LoanService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanLimitController extends BaseResponse {

    LoanLimitService loanLimitService;

    LoanService loanService;

    LoanDetailService loanDetailService;

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

    @PostMapping("get-loan-by-Id")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getLoanById(HttpServletRequest httpServletRequest,
                                         @RequestBody LoanDetailRequest request) {
        return response(toResult(loanDetailService.getLoanById(request)));
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

    /*
     * Lấy ra tất cả danh sách khoản vay
     * */
    @PostMapping("get-loan-list")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getLoanList(HttpServletRequest httpServletRequest,
                                         @RequestBody LoanRequest loanRequest) {
        return response(toResult(loanService.getLoanList(loanRequest)));
    }

    /*
     * Tạo lệnh tất toán trước hạn
     * */
    @PostMapping("pre-payment")
    @Transactional(readOnly = true)
    public ResponseEntity<?> prePayment(@RequestBody PrePaymentRequest request) {
        return response(toResult(loanService.prePayment(request)));
    }

    /*
     * Duyệt lệnh tất toán trước hạn
     * */
    @PostMapping("approve-pre-payment")
    @Transactional(readOnly = true)
    public ResponseEntity<?> approvePrePayment(@RequestBody ApprovePrePaymentRequest request) {
        return response(toResult(loanService.approvePrePayment(request)));
    }

    @PostMapping("operator-loan")
    @Transactional(readOnly = true)
    public ResponseEntity<?> operatorLoan(HttpServletRequest httpServletRequest,
                                          @RequestBody OperatorLoanRequest operatorLoanRequest) {
        return response(toResult(loanService.operatorLoan(operatorLoanRequest)));

    }
}
