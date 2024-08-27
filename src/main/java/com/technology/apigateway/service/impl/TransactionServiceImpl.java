package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.OperatorTransactionRequest;
import com.technology.apigateway.controller.request.TransactionRequest;
import com.technology.apigateway.database.entity.OperatorTransaction;
import com.technology.apigateway.database.entity.TransactionStatus;
import com.technology.apigateway.database.repository.TransactionOperatorRepository;
import com.technology.apigateway.database.repository.TransactionRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.TransactionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("transactionService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    TransactionOperatorRepository transactionOperatorRepository;

    @Override
    public TransactionStatus topUp(TransactionRequest transactionRequest) {
        TransactionStatus transactionStatus;
        try {
            transactionStatus = transactionRepository.topUp(
                    transactionRequest.getCustId(),
                    transactionRequest.getTranValue(),
                    transactionRequest.getCreatedUser());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return transactionStatus;
    }

    @Override
    public TransactionStatus withDraw(TransactionRequest transactionRequest) {
        TransactionStatus transactionStatus;
        try {
            transactionStatus = transactionRepository.withDraw(
                    transactionRequest.getCustId(),
                    transactionRequest.getTranValue(),
                    transactionRequest.getCreatedUser());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return transactionStatus;
    }

    @Override
    public TransactionStatus approveOrder(TransactionRequest transactionRequest) {
        TransactionStatus transactionStatus;
        try {
            transactionStatus = transactionRepository.approveOrder(
                    transactionRequest.getId(),
                    transactionRequest.getStatus(),
                    transactionRequest.getApprovedUser());

            if (!transactionStatus.getStatus().equals("01")) {
                throw new BusinessException(ErrorCode.UNKNOWN_ERROR, transactionStatus.getDescription());
            }

        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return transactionStatus;
    }

    @Override
    public List<OperatorTransaction> operatorTransaction(OperatorTransactionRequest operatorTransactionRequest) {
        List<OperatorTransaction> transactionList = transactionOperatorRepository.operatorTransaction(
                operatorTransactionRequest.getFullName(),
                operatorTransactionRequest.getMobile(),
                operatorTransactionRequest.getIdNumber(),
                operatorTransactionRequest.getBranch(),
                operatorTransactionRequest.getTranName(),
                operatorTransactionRequest.getTranDes(),
                operatorTransactionRequest.getFromDate(),
                operatorTransactionRequest.getToDate(),
                operatorTransactionRequest.getUserId());
        if (transactionList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, ErrorCode.NOT_FOUND_OPERATOR);
        }
        return transactionList;
    }
}
