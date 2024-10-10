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
@Table(name = "LOAN")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "ListLoan.getLoanList", procedureName = "pck_loan.getLoanList", resultClasses = ListLoan.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_lnFromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_lnToDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_term", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_rate", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_rateOvd", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_feeRate", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_termType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_loanStatus", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_saleid", mode = ParameterMode.IN, type = Integer.class),
        })
})
public class ListLoan {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CUSTID")
    private Integer custId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "LNDATE")
    private String lnDate;

    @Column(name = "AMOUNT")
    private String amount;

    @Column(name = "TERM")
    private String term;

    @Column(name = "RATE")
    private String rate;

    @Column(name = "FEERATE")
    private String feerate;

    @Column(name = "RATEOVD")
    private String rateOvd;

    @Column(name = "PRINNML")
    private String prinnml;

    @Column(name = "PRINOVD")
    private String prinovd;

    @Column(name = "LNCLASS")
    private String lnClass;

    @Column(name = "INTNML")
    private String intnml;

    @Column(name = "INTOVD")
    private String intovd;

    @Column(name = "ASSETMANAGEMENTFEE")
    private String assetManagementFee;

    @Column(name = "ASSETMANAGEMENTOVD")
    private String assetManagementOvd;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PAYTYPE")
    private String payType;

    @Column(name = "TERMTYPE")
    private String termType;

    @Column(name = "CREATEDDATE")
    private String createdDate;

    @Column(name = "LOANSTATUS")
    private String loanStatus;

    @Column(name = "IDNUMBER")
    private String idNumber;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "REGID")
    private Integer regId;

    @Column(name = "DOCUMENTNO")
    private String documentNo;

    @Column(name = "INSURANCEFEE")
    private Integer insuranceFee;

    @Column(name = "GUARANTEETRANFEE")
    private Integer guaranteeTranFee;

    @Column(name = "SALENAME")
    private String saleName;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "EXPERTISEFEERATE")
    private Double expertiseFeeRate;

    @Column(name = "OUTSTANDINGAMOUNT")
    private Double outstandingAmount;

    @Column(name = "PREPAYMENTFEE")
    private Double prePaymentFee;
}
