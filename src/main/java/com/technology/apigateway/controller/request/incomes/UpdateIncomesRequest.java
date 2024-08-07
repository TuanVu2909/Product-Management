package com.technology.apigateway.controller.request.incomes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateIncomesRequest {
    private Integer id;
    private Integer userId;
    private String companyName;
    private String companyAddress;
    private String jobTitle;
    private Integer salary;
    private String creditInsName;
    private Integer month;
    private Integer principalPerMonth;
    private Integer interestPerMonth;
    private Integer totalPerMonth;
    private String incomeType;
}
