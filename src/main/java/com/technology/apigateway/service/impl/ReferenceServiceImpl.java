package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.references.ReferenceRequest;
import com.technology.apigateway.controller.request.references.UpdateReferenceRequest;
import com.technology.apigateway.database.entity.status.CustomerStatus;
import com.technology.apigateway.database.entity.ReferencesEntity;
import com.technology.apigateway.database.repository.CustomerStatusRepository;
import com.technology.apigateway.database.repository.ReferencesRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("referenceService")
public class ReferenceServiceImpl implements ReferenceService {

    @Autowired
    CustomerStatusRepository customerStatusRepository;

    @Autowired
    ReferencesRepository referencesRepository;

    @Override
    public CustomerStatus createReference(ReferenceRequest referenceRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.createReference(
                    referenceRequest.getUserId(),
                    referenceRequest.getRefName(),
                    referenceRequest.getMobile(),
                    referenceRequest.getRelation(),
                    referenceRequest.getJob(),
                    referenceRequest.getRegId());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

    @Override
    public CustomerStatus updateReference(UpdateReferenceRequest updateReferenceRequest) {
        //        int id = updateReferenceRequest.getId();
//        int userId = updateReferenceRequest.getUserId();
//        if (!customerStatusRepository.existsById((Integer.toString(id)))) {
//            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, "ID không có trong cơ sở dữ liệu.");
//        }
//
//        if (!customerStatusRepository.existsById((Integer.toString(userId)))) {
//            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, "ID không có trong cơ sở dữ liệu.");
//        }

        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.updateReference(
                    updateReferenceRequest.getId(),
                    updateReferenceRequest.getUserId(),
                    updateReferenceRequest.getRefName(),
                    updateReferenceRequest.getMobile(),
                    updateReferenceRequest.getRelation(),
                    updateReferenceRequest.getJob());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

    @Override
    public ReferencesEntity deleteReferencesById(int id) {
        referencesRepository.deleteById(id);
        return null;
    }
}
