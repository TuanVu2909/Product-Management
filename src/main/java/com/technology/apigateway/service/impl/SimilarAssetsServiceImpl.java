package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.SimilarAssetsRequest;
import com.technology.apigateway.controller.request.similarAssets.CreateSimilarAssetsRequest;
import com.technology.apigateway.database.entity.CustomerStatus;
import com.technology.apigateway.database.entity.SimilarAssets;
import com.technology.apigateway.database.repository.CustomerStatusRepository;
import com.technology.apigateway.database.repository.SimilarAssetsRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.SimilarAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("similarAssets")
public class SimilarAssetsServiceImpl implements SimilarAssetsService {

    @Autowired
    CustomerStatusRepository customerStatusRepository;


    @Autowired
    SimilarAssetsRepository similarAssetsRepository;

    @Override
    public CustomerStatus createSimilarAssets(CreateSimilarAssetsRequest createSimilarAssetsRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.createSimilarAssets(
                    createSimilarAssetsRequest.getUserId(),
                    createSimilarAssetsRequest.getValue(),
                    createSimilarAssetsRequest.getLinkWebsite());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

    @Override
    public CustomerStatus updateSimilarAssets(SimilarAssetsRequest similarAssetsRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.updateSimilarAssets(
                    similarAssetsRequest.getId(),
                    similarAssetsRequest.getUserId(),
                    similarAssetsRequest.getValue(),
                    similarAssetsRequest.getLinkWebsite());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

    @Override
    public SimilarAssets deleteSimilarAssetsById(int id) {
        similarAssetsRepository.deleteById(id);
        return null;
    }
}
