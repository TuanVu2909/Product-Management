package com.technology.apigateway.controller.request.similarAssets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSimilarAssetsRequest {
    private int userId;
    private double value;
    private String linkWebsite;
}
