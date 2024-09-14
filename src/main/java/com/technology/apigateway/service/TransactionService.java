package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.OperatorTransactionRequest;
import com.technology.apigateway.controller.request.TransactionRequest;
import com.technology.apigateway.database.entity.OperatorTransaction;
import com.technology.apigateway.database.entity.status.TransactionStatus;

import java.util.List;

public interface TransactionService {

    TransactionStatus topUp(TransactionRequest transactionRequest);

    TransactionStatus withDraw(TransactionRequest transactionRequest);

    TransactionStatus approveOrder(TransactionRequest transactionRequest);

    List<OperatorTransaction> operatorTransaction(OperatorTransactionRequest operatorTransactionRequest);

}
