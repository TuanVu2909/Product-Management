package com.technology.apigateway.controller.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@ToString
public class CustomerRequest {

    private int id;

    @NotBlank(message = "Fullname không được để trống")
    private String fullName;

    private String mobile;
    private String dob;
    private String idType;
    private String idNumber;
    private String idDate;
    private String idPlace;
    private String idExpired;
    private String address;
    private int wardId;
    private int districtId;
    private int provinceId;
    private String email;
    private String married;
    private String profession;
    private String education;
    private String custType;
    private String status;
    private String createdDate;
    private int income;
    private String residency;
    private String residencyTime;
    private int dependentPerson;
    private int workingPeriod;
    private String residenceAddress;
    private int residenceWardId;
    private int residenceDistrictId;
    private int residenceProvinceId;
    private String bankName;
    private String bankAccountNumber;
    private int gender;
    private String relationshipWithFiny;
    private String workAddress;
    private String nameCompany;
    private String ethics;
    private String descriptionWork;
}
