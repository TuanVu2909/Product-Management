package com.technology.apigateway.service.impl;

import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.database.entity.status.BatchStatus;
import com.technology.apigateway.database.repository.BatchRepository;
import com.technology.apigateway.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchRepository batchRepository;

    @Override
    public BatchStatus runBatch(BatchRequest request) {
        return batchRepository.runBatch(request);
    }
}
