package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegionRequest {
    private String rid;
    private String name;
    private String description;
    private int status;
}
