package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.database.entity.BatchStatus;
import com.technology.apigateway.database.repository.BatchStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("batchService")
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchStatusRepository batchStatusRepository;

    @Override
    public BatchStatus runBatch(BatchRequest batchRequest) {
        BatchStatus batchStatus;
        try {
            batchStatus = batchStatusRepository.runBatch(batchRequest.getUserId());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return batchStatus;
    }
}
