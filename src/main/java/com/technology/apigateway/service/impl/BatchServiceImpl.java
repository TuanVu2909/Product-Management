package com.technology.apigateway.service.impl;

import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.database.entity.status.BatchStatus;
import com.technology.apigateway.database.repository.BatchRepository;
import com.technology.apigateway.service.BatchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service("batchService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BatchServiceImpl implements BatchService {

    BatchRepository batchRepository;

    @Override
    public BatchStatus runBatch(BatchRequest request) {
        return batchRepository.runBatch(request.getUserId());
    }
}
