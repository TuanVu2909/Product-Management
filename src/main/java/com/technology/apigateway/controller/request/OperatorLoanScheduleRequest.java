package com.technology.apigateway.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorLoanScheduleRequest {
    Integer loanId;

    Integer loanScheduleId;

    Integer custId;

    String fullName;

    String mobile;

    String idNumber;

    String branch;

    String payType;

    String loanStatus;

    String loanType;

    String saleFullName;

    String lnFromDate;

    String lnToDate;

    Integer userId;
}
