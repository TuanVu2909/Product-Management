package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupFunctionRequest {
    private String gfid;
    private String name;
    private String functions;
    private int status;
}
