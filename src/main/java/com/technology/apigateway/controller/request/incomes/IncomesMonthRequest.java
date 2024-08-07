package com.technology.apigateway.controller.request.incomes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomesMonthRequest {
    private int month;
    private double incomeMonth;
    private String creditInsName;
    private double principalPerMonth;
    private double interestPerMonth;
    private double totalPerMonth;
    private String incomeType;
}
