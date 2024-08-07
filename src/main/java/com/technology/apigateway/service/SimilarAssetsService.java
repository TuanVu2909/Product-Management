package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.SimilarAssetsRequest;
import com.technology.apigateway.database.entity.CustomerStatus;

public interface SimilarAssetsService {

    CustomerStatus updateSimilarAssets(SimilarAssetsRequest similarAssetsRequest);
}
