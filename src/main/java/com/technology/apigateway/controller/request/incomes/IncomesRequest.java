package com.technology.apigateway.controller.request.incomes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomesRequest {

    private int month;
    private double incomePerMonth;
    private String creditInsName;
    private double principalPerMonth;
    private double interestPerMonth;
    private double totalPerMonth;
    private String incomeType;
}
