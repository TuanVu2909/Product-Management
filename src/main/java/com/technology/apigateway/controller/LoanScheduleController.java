package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.OperatorLoanScheduleRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.LoanScheduleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class LoanScheduleController extends BaseResponse {

    LoanScheduleService loanScheduleService;

    @GetMapping("get-loan-schedule-by-loan-id/{loanId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getLoanScheduleByLoanId(HttpServletRequest httpServletRequest, @PathVariable int loanId) {
        return response(toResult(loanScheduleService.getLoanScheduleByLoanId(loanId)));
    }

    @PostMapping("operator-loan-schedule")
    @Transactional(readOnly = true)
    public ResponseEntity<?> operatorLoanSchedule(HttpServletRequest httpServletRequest, @RequestBody OperatorLoanScheduleRequest operatorLoanScheduleRequest) {
        return response(toResult(loanScheduleService.operatorLoanSchedule(operatorLoanScheduleRequest)));
    }
}
