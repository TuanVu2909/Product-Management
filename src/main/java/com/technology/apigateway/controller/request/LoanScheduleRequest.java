package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class LoanScheduleRequest {
    private int id;

    private int loanId;

    private int dueNo;

    private String duedate;

    private double prinnml;

    private double prinovd;

    private double intnml;

    private double intovd;

    private double prinpaid;

    private double intpaid;

    private double assetManagementFee;

    private double assetManagementOvd;

    private double assetManagementPaid;

    private String paidDate;

    private double estPrin;

    private double estInt;

    private double cntDays;

    private double feeOvd;

    private double feeOvdPaid;

    private double expertiseFee;

    private double expertiseFeeOvd;

    private double expertiseFeePaid;
}
