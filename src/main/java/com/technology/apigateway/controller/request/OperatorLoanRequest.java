package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperatorLoanRequest {

    private Integer id;

    private Integer custId;

    private String fullName;

    private String mobile;

    private String idNumber;

    private String loanType;

    private Integer term;

    private Integer rate;

    private Integer rateOvd;

    private Integer feeRate;

    private String status;

    private String payType;

    private String termType;

    private String loanStatus;

    private Integer saleId;

    private String saleFullName;

    private String lnFromDate;

    private String lnToDate;

}
