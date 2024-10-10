package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.database.entity.status.BatchStatus;
import com.technology.apigateway.database.repository.BatchRepository;
import com.technology.apigateway.exception.BusinessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class BatchRepositoryImpl implements BatchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BatchStatus runBatch(BatchRequest request) {
        try {
            BatchStatus batchStatus = new BatchStatus();
            // Tạo StoredProcedureQuery
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("pck_batch.runbatch");

            // Đăng ký các tham số IN
            storedProcedureQuery.registerStoredProcedureParameter("pv_userId", String.class, ParameterMode.IN);
            storedProcedureQuery.setParameter("pv_userId", request.getUserId());

            // Đăng ký các tham số OUT
            storedProcedureQuery.registerStoredProcedureParameter("pv_errcode", String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter("pv_errmsg", String.class, ParameterMode.OUT);
            storedProcedureQuery.registerStoredProcedureParameter("pv_refcursor", Void.class, ParameterMode.REF_CURSOR);
            // Thực thi stored procedure
            storedProcedureQuery.execute();

            // Lấy tổng số bản ghi từ tham số OUT
            String errCode = (String) storedProcedureQuery.getOutputParameterValue("pv_errcode");
            String errMsg = (String) storedProcedureQuery.getOutputParameterValue("pv_errmsg");

            batchStatus.setStatus(errCode);
            batchStatus.setDescription(errMsg);
            return batchStatus;

        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
