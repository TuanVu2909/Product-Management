package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetIncomeCustomerByIdAndIncomeType {
    private Integer userId;
    private String incomeType;
}
