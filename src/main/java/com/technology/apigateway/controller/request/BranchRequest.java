package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BranchRequest {
    private String bid;
    private String name;
    private String aid;
    private int status;
    private String rid;
    private String fullAddress;
}
