package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AreaRequest {
    private String aid;
    private String name;
    private String rid;
    private String description;
    private int status;
}
