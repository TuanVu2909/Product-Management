package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimilarAssetsRequest {
    private int id;
    private int userId;
    private double value;
    private String linkWebsite;
}
