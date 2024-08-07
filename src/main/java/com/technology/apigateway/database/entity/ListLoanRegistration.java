package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "LOANREGISTRATION")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "ListLoanRegistration.getLoanRegistration", procedureName = "pck_loan.getLoanRegistration", resultClasses = ListLoanRegistration.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = int.class)
        }),
        @NamedStoredProcedureQuery(name = "ListLoanRegistration.getListLoanRegistration", procedureName = "pck_loan.getListLoanRegistration", resultClasses = ListLoanRegistration.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_vehicleType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_registrationNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_engineNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_chassisNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_term", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_saleId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_coId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_regFromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_regToDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_termType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleOwnerName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleColor", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_addressVehicleDocuments", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleOrigin", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleRegistrationIssued", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleRegistrationDate", mode = ParameterMode.IN, type = Date.class),
                @StoredProcedureParameter(name = "pv_purposeUsingLoan", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehicleBrand", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.IN, type = String.class)
        })
})
public class ListLoanRegistration {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CUSTID")
    private String custId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "IDNUMBER")
    private String idNumber;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "REGDATE")
    private String regDate;

    @Column(name = "VEHICLETYPE")
    private String vehicleType;

    @Column(name = "VEHICLENUMBER")
    private String vehicleNumber;

    @Column(name = "REGISTRATIONNUMBER")
    private String registrationNumber;

    @Column(name = "ENGINENUMBER")
    private String engineNumber;

    @Column(name = "CHASSISNUMBER")
    private String chassisNumber;

    @Column(name = "VEHICLEPRICE")
    private String vehiclePrice;

    @Column(name = "LOANAMOUNT")
    private String loanAmount;

    @Column(name = "TERM")
    private String term;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "SALE")
    private String sale;

    @Column(name = "CO")
    private String co;

    @Column(name = "SALENOTE")
    private String saleNote;

    @Column(name = "CONOTE")
    private String coNote;

    @Column(name = "INCOMEPROVETYPE")
    private String incomeProveType;

    @Column(name = "TERMTYPE")
    private String termType;

    @Column(name = "VEHICLEOWNERNAME")
    private String vehicleOwnerName;

    @Column(name = "VEHICLECOLOR")
    private String vehicleColor;

    @Column(name = "ADDRESSVEHICLEDOCUMENTS")
    private String addressVehicleDocuments;

    @Column(name = "VEHICLEORIGIN")
    private String vehicleOrigin;

    @Column(name = "VEHICLEREGISTRATIONISSUED")
    private String vehicleRegistrationIssued;

    @Column(name = "VEHICLEREGISTRATIONDATE")
    private Date vehicleRegistrationDate;

    @Column(name = "PURPOSEUSINGLOAN")
    private String purposeUsingLoan;

    @Column(name = "VEHICLEBRAND")
    private String vehicleBrand;

    @Column(name = "VEHICLETYPEVALUE")
    private String vehicleTypeValue;

    @Column(name = "STATUSVALUE")
    private String statusValue;

    @Column(name = "INCOMEPROVETYPEVALUE")
    private String incomeProveTypeValue;

    @Column(name = "VEHICLEID")
    private String vehicleId;

    @Column(name = "SALEID")
    private String saleId;

    @Column(name = "COID")
    private String coId;

    @Column(name = "LOANTYPE")
    private String loanType;

    @Column(name = "USEFOR")
    private String useFor;

    @Column(name = "CRACK")
    private String crack;

    @Column(name = "SCRATCH")
    private String scratch;

    @Column(name = "OTHERS")
    private String others;

    @Column(name = "PAYTYPE")
    private String payType;

    @Column(name = "WORKINGPERIOD")
    private String workingPeriod;

    @Column(name = "RATEANDFEE")
    private String rateAndFee;

    @Column(name = "FUEL")
    private String fuel;

    @Column(name = "NUMBERPEOPLEALLOW")
    private String numberPeopleAllow;

    @Column(name = "FINYPAYPERMONTH")
    private String finyPay;

    @Column(name = "VRATE")
    private String vRate;

    @Column(name = "VRATEMANAGE")
    private String vRateManage;

    @Column(name = "VRATELATE")
    private String vRateLate;

    @Column(name = "VRATECO")
    private String vRateCo;

    @Column(name = "VRATESOON")
    private String vRateSoon;

    @Column(name = "FEEFIRSTMANAGEMENT")
    private String feeFirstManagement;

    @Column(name = "FEEINSURANCE")
    private String feeInsurance;

    @Column(name = "FEEGUARANTEE")
    private String feeGuarantee;

    @Column(name = "BRANCH")
    private String branch;
}
