package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DistrictRequest {

    private int id;

    private String dName;

    private String enName;

    private String dLevel;

    private int pid;
}
