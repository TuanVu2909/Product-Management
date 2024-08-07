package com.technology.apigateway.controller.request;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class LoanRegistrationRequest {
    private Integer id;
    private Integer custId;
    private LocalDateTime regDate;
    private String vehicleType;
    private Integer vehicleId;
    private String vehicleNumber;
    private String registrationNumber;
    private String engineNumber;
    private String chassisNumber;
    private Integer vehiclePrice;
    private Integer loanAmount;
    private Integer term;
    private String status;
    private Integer saleId;
    private Integer coId;
    private String saleNote;
    private String coNote;
    private LocalDateTime createdDate;
    private String incomeProveType;
    private String termType;
    private String regFromDate;
    private String regToDate;
    private String vehicleOwnerName;
    private String vehicleColor;
    private String addressVehicleDocuments;
    private String loanType;
    private String vehicleOrigin;
    private String vehicleRegistrationIssued;
    private Date vehicleRegistrationDate;
    private String purposeUsingLoan;
    private String vehicleBrand;
    private String payType;
    private String fuel;
    private String numberPeopleAllow;
    private Integer finyPay;
}
