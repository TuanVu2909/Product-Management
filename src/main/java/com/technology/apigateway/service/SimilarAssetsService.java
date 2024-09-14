package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.SimilarAssetsRequest;
import com.technology.apigateway.controller.request.similarAssets.CreateSimilarAssetsRequest;
import com.technology.apigateway.database.entity.status.CustomerStatus;
import com.technology.apigateway.database.entity.SimilarAssets;

public interface SimilarAssetsService {

    CustomerStatus createSimilarAssets(CreateSimilarAssetsRequest createSimilarAssetsRequest);

    CustomerStatus updateSimilarAssets(SimilarAssetsRequest similarAssetsRequest);

    SimilarAssets deleteSimilarAssetsById(int id);


}
