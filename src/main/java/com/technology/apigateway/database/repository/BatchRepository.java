package com.technology.apigateway.database.repository;

import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.database.entity.status.BatchStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface BatchRepository{

    BatchStatus runBatch(BatchRequest request);
}
