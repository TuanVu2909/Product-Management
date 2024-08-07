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
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "OperatorLoan.operatorLoan", procedureName = "pck_report.operatorLoan", resultClasses = OperatorLoan.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_term", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_rate", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_rateOvd", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_feeRate", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_termType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_loanStatus", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_saleId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_saleFullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_lnFromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_lnToDate", mode = ParameterMode.IN, type = String.class),
        })
})
public class OperatorLoan {
    @Id
    @Column(name = "SALEID")
    private Integer saleId;

    @Column(name = "IDNUMBER")
    private String idNumber;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "ID")
    private Integer id;

    @Column(name = "CUSTID")
    private Integer custId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "LNDATE")
    private Date lndate;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "TERM")
    private Integer term;

    @Column(name = "RATE")
    private Integer rate;

    @Column(name = "FEERATE")
    private Integer feerate;

    @Column(name = "RATEOVD")
    private Integer rateovd;

    @Column(name = "PRINNML")
    private Integer prinnml;

    @Column(name = "PRINOVD")
    private Integer prinovd;

    @Column(name = "LNCLASS")
    private String lnclass;

    @Column(name = "INTNML")
    private Integer intnml;

    @Column(name = "INTOVD")
    private Integer intovd;

    @Column(name = "ASSETMANAGEMENTFEE")
    private Integer assetmanagementfee;

    @Column(name = "ASSETMANAGEMENTOVD")
    private Integer assetmanagementovd;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PAYTYPE")
    private String paytype;

    @Column(name = "TERMTYPE")
    private String termtype;

    @Column(name = "CREATEDDATE")
    private Timestamp createddate;

    @Column(name = "LOANSTATUS")
    private String loanstatus;

    @Column(name = "REGID")
    private Integer regid;

    @Column(name = "LOANTYPE")
    private String loantype;

    @Column(name = "SALEFULLNAME")
    private String salefullname;
}
