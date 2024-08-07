package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProvinceRequest {
    private int id;

    private String pName;

    private String enName;

    private String pLevel;

    private String shortName;
}
