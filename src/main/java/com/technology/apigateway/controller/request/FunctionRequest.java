package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FunctionRequest {
    private String functionId;

    private String functionName;

    private int status;
}
