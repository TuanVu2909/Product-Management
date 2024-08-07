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

@Entity
@Getter
@Setter
@ToString
@Table(name = "CUSTOMER")
@NamedStoredProcedureQueries({
                @NamedStoredProcedureQuery(name = "Customer.getAllCustomer", procedureName = "pck_customer.get_all_customer", resultClasses = Customer.class, parameters = {
                                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),

                @NamedStoredProcedureQuery(name = "Customer.getCustomerWhere", procedureName = "pck_customer.getCustomerWhere", resultClasses = Customer.class, parameters = {
                                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                                @StoredProcedureParameter(name = "pv_careId", mode = ParameterMode.IN, type = Integer.class),
                                @StoredProcedureParameter(name = "pv_idNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = Integer.class),
                                
                })
})
public class Customer {
        @Id
        @Column(name = "ID")
        private int id;

        @Column(name = "FULLNAME")
        private String fullName;

        @Column(name = "MOBILE")
        private String mobile;

        @Column(name = "DOB")
        private String dob;

        @Column(name = "IDTYPE")
        private String idType;

        @Column(name = "IDNUMBER")
        private String idNumber;

        @Column(name = "IDDATE")
        private String idDate;

        @Column(name = "IDPLACE")
        private String idPlace;

        @Column(name = "IDEXPIRED")
        private String idExpired;

        @Column(name = "ADDRESS")
        private String address;

        @Column(name = "WARDID")
        private int wardId;

        @Column(name = "DISTRICTID")
        private int districtId;

        @Column(name = "PROVINCEID")
        private int provinceId;

        @Column(name = "EMAIL")
        private String email;

        @Column(name = "MARRIED")
        private String married;

        @Column(name = "PROFESSION")
        private String profession;

        @Column(name = "EDUCATION")
        private String education;

        @Column(name = "CUSTTYPE")
        private String custType;

        @Column(name = "STATUS")
        private String status;

        @Column(name = "CREATEDDATE")
        private String createdDate;

        @Column(name = "INCOME")
        private int income;

        @Column(name = "RESIDENCY")
        private String residency;

        @Column(name = "RESIDENCYTIME")
        private String residencyTime;

        @Column(name = "DEPENDENTPERSON")
        private int dependentPerson;

        @Column(name = "WORKINGPERIOD")
        private int workingPeriod;

        @Column(name = "RESIDENCEADDRESS")
        private String residenceAddress;

        @Column(name = "RESIDENCEWARDID")
        private int residenceWardId;

        @Column(name = "RESIDENCEDISTRICTID")
        private int residenceDistrictId;

        @Column(name = "RESIDENCEPROVINCEID")
        private int residenceProvinceId;

        @Column(name = "ADMINID")
        private int saleId;

        @Column(name = "ADMINNAME")
        private String saleName;

        @Column(name = "ADMINMOBILE")
        private String saleMobile;

        @Column(name = "BANKNAME")
        private String bankName;

        @Column(name = "BANKACCOUNTNUMBER")
        private String bankAccountNumber;

        @Column(name = "GENDER")
        private int gender;

        @Column(name = "GENDERNAME")
        private String genderName;

        @Column(name = "RELATIONSHIPWITHFINY")
        private String relationshipWithFiny;

        @Column(name = "WORKADDRESS")
        private String workAddress;

        @Column(name = "NAMECOMPANY")
        private String nameCompany;

        @Column(name = "ETHICS")
        private String ethics;

        @Column(name = "DESCRIPTIONWORK")
        private String descriptionWork;
}
