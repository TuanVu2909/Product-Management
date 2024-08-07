package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WardRequest {
    private int id;

    private String wName;

    private String enName;

    private String wLevel;

    private int did;
}
