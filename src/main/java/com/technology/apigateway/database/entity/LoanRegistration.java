package com.technology.apigateway.database.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "LOANREGISTRATION")
public class LoanRegistration {
        @Id
        @Column(name = "ID")
        private int id;
    
        @Column(name = "CUSTID")
        private int custId;
    
        @Column(name = "REGDATE")
        private Date regDate;
    
        @Column(name = "VEHICLETYPE")
        private String vehicleType;
    
        @Column(name = "VEHICLEID")
        private int vehicleId;
    
        @Column(name = "VEHICLENUMBER")
        private String vehicleNumber;
    
        @Column(name = "REGISTRATIONNUMBER")
        private String registrationNumber;
    
        @Column(name = "ENGINENUMBER")
        private String engineNumber;
    
        @Column(name = "CHASSISNUMBER")
        private String chassisNumber;
    
        @Column(name = "VEHICLEPRICE")
        private int vehiclePrice;
    
        @Column(name = "LOANAMOUNT")
        private int loanAmount;
    
        @Column(name = "TERM")
        private int term;
    
        @Column(name = "STATUS")
        private String status;
    
        @Column(name = "SALEID")
        private int saleId;
    
        @Column(name = "COID")
        private int coId;
    
        @Column(name = "SALENOTE")
        private String saleNote;
    
        @Column(name = "CONOTE")
        private String coNote;
    
        @Column(name = "CREATEDDATE")
        private Date createdDate;
    
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

        @Column(name = "LOANTYPE")
        private String loanType;

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

        @Column(name = "PAYTYPE")
        private String payType;

        @Column(name = "FUEL")
        private String fuel;

        @Column(name = "NUMBERPEOPLEALLOW")
        private String numberPeopleAllow;
}
