package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AllCodeRequest {
    private int id;

    private String code;

    private String type;

    private String name;

    private int lstOrder;

    private int state;
}
