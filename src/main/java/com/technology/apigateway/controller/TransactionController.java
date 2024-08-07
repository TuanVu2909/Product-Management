package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.OperatorTransactionRequest;
import com.technology.apigateway.controller.request.TransactionRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TransactionController extends BaseResponse {
    @Autowired
    TransactionService transactionService;

    @PostMapping("top-up")
    @Transactional(readOnly = true)
    public ResponseEntity<?> topUp(HttpServletRequest httpServletRequest,
                                   @RequestBody TransactionRequest transactionRequest) {
        return response(toResult(transactionService.topUp(transactionRequest)));
    }

    @PostMapping("with-draw")
    @Transactional(readOnly = true)
    public ResponseEntity<?> withDraw(HttpServletRequest httpServletRequest,
                                      @RequestBody TransactionRequest transactionRequest) {
        return response(toResult(transactionService.withDraw(transactionRequest)));
    }

    @PostMapping("approve-order")
    @Transactional(readOnly = true)
    public ResponseEntity<?> approveOrder(HttpServletRequest httpServletRequest,
                                          @RequestBody TransactionRequest transactionRequest) {
        return response(toResult(transactionService.approveOrder(transactionRequest)));
    }

    @PostMapping("operator-transaction")
    @Transactional(readOnly = true)
    public ResponseEntity<?> operatorTransaction(HttpServletRequest httpServletRequest,
                                                 @RequestBody OperatorTransactionRequest operatorTransactionRequest) {
        return response(toResult(transactionService.operatorTransaction(operatorTransactionRequest)));
    }
}
