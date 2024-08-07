package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "LOAN")
public class Loan {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CUSTID")
    private int custId;

    @Column(name = "LNDATE")
    private Date lnDate;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "TERM")
    private int term;

    @Column(name = "RATE")
    private int rate;

    @Column(name = "PRINNML")
    private int prinnml;

    @Column(name = "PRINOVD")
    private int prinovd;

    @Column(name = "INTNML")
    private int intnml;

    @Column(name = "INTOVD")
    private int intovd;

    @Column(name = "RATEOVD")
    private int rateovd;

    @Column(name = "EXPERTISEFEE")
    private int expertiseFee;

    @Column(name = "ASSETMANAGEMENTFEE")
    private int assetManagementFee;

    @Column(name = "EXPERTISEOVD")
    private int expertiseOvd;

    @Column(name = "ASSETMANAGEMENTOVD")
    private int assetManagementOvd;

    @Column(name = "REGID")
    private int regId;

    @Column(name = "PRINPAID")
    private int prinpaid;

    @Column(name = "INTPAID")
    private int intpaid;

    @Column(name = "EXPERTISEPAID")
    private int expertisePaid;

    @Column(name = "ASSETMANAGEMENTPAID")
    private int assetManagementPaid;

    @Column(name = "PAYTYPE")
    private String payType;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATEDDATE")
    private Date createdDate;
}
