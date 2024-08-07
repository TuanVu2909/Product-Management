package com.technology.apigateway.controller.request;

import com.technology.apigateway.controller.request.incomes.IncomesMonthRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

import com.technology.apigateway.controller.request.incomes.IncomesRequest;
import com.technology.apigateway.controller.request.references.ReferenceRequest;


@Getter
@Setter
@ToString
public class MainRequest {
    // customer request
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
    // customer care request
    private int custId;
    private String careId;
    private String careType;
    // private String createdDateCustomerCareRequest; dùng createDate ở trên
    // customer
    // loan registration request
    // private Integer custIdLoanRegistration; chỉ sử dụng một custId
    private String vehicleType;
    private Integer vehicleId;
    private String vehicleNumber;
    private String registrationNumber;
    private String engineNumber;
    private String chassisNumber;
    private Integer vehiclePrice;
    private Integer loanAmount;
    private Integer term;
    private Integer saleId;
    private String saleNote;
    private String incomeProveType;
    private String termType;
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

    private List<ReferenceRequest> references;
    private List<IncomesRequest> incomes;
    private List<IncomesMonthRequest> incomeMonth;
    private List<SimilarAssetsRequest> similarAssets;

    // guardians
    private String guardName;
    private String guardBirth;
    private String guardMobile;
    private String guardMaritalStatus;
    private String guardIdNumber;
    private String guardIdDate;
    private String guardIdAddress;
    private String guardIdPlace;
    private String guardAddress;
    private String guardStatusAddress;
    private String guardCurrentAddress;
    private String guardIsFieldWork;
    private String guardRelationship;

    // vehicle state
    private int vehUseFor;
    private int vehCrack;
    private int vehScratch;
    private int vehOthersState;

}
