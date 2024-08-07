package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperatorLoanScheduleRequest {
    public Integer loanId;

    public Integer loanScheduleId;

    public Integer custId;

    public String fullName;

    public String mobile;

    public String idNumber;

    public String branch;

    public String payType;

    public String loanStatus;

    public String loanType;

    public String saleFullName;

    public String lnFromDate;

    public String lnToDate;

}
