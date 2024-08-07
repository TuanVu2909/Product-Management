package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetCustomerRequest {
    private Integer careId;
    private String idNumber;
    private Integer custId;
    private Integer regId;

}
