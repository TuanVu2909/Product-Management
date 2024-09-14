package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.status.BatchStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("batchStatusRepository")
public interface BatchStatusRepository extends CrudRepository<BatchStatus, Integer> {
    @Procedure("BatchStatus.runBatch")
    BatchStatus runBatch(@Param("pv_userId") Integer userId);
}
