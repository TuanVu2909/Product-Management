package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.database.entity.status.BatchStatus;

public interface BatchService {

    BatchStatus runBatch(BatchRequest batchRequest);
}
