package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class LoanRequest {
    private Integer id;

    private Integer custId;

    private Date lndate;

    private Integer amount;

    private Integer term;

    private Integer rate;

    private Integer prinnml;

    private Integer prinovd;

    private Integer Integernml;

    private Integer Integerovd;

    private Integer rateovd;

    private Integer expertiseFee;

    private Integer assetManagementFee;

    private Integer expertiseOvd;

    private Integer assetManagementOvd;

    private Integer regId;

    private Integer prinpaid;

    private Integer Integerpaid;

    private Integer expertisePaid;

    private Integer assetManagementPaid;

    private String payType;

    private String status;

    private Date createddate;


    private String fullName;

    private String lnFromDate;

    private String lnToDate;

    private Integer feeRate;

    private String termType;

    private String loanStatus;

    private Integer insuranceFee;

    private Integer guaranteeTranFee;

    // create prePayment
    private Integer createdUser;

    private Integer saleId;

    private Double expertiseFeePrePaid;

    private Double assetManagementFeeRate;

    private Double expertiseFeeRate;

    private Double changeRate;

    private Double changeRateOvd;

    private Double prePaymentFeeRate;

    private String documentNo;
}
