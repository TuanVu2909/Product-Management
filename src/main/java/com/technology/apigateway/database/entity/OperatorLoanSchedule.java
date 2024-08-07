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
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "OperatorLoanSchedule.operatorLoanSchedule", procedureName = "pck_report.operatorLoanSchedule", resultClasses = OperatorLoanSchedule.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_loanId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_loanScheduleId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_loanStatus", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_saleFullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_lnFromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_lnToDate", mode = ParameterMode.IN, type = String.class)
        })
})
public class OperatorLoanSchedule {
    @Id
    @Column(name = "LOANSCHEDULEID")
    private String loanScheduleId;

    @Column(name = "LOANID")
    private String loanId;

    @Column(name = "CUSTID")
    private int custId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "IDNUMBER")
    private String idNumber;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "DUEDATE")
    private Date duedate;

    @Column(name = "DUENO")
    private int dueno;

    @Column(name = "PRINNML")
    private String prinnml;

    @Column(name = "PRINOVD")
    private String prinovd;

    @Column(name = "LNCLASS")
    private String lnclass;

    @Column(name = "INTNML")
    private String intnml;

    @Column(name = "INTOVD")
    private String intovd;

    @Column(name = "ASSETMANAGEMENTFEE")
    private String assetmanagementfee;

    @Column(name = "ASSETMANAGEMENTOVD")
    private String assetmanagementovd;

    @Column(name = "EXPERTISEFEE")
    private String expertisefee;

    @Column(name = "EXPERTISEFEEOVD")
    private String expertisefeeovd;

    @Column(name = "PAYTYPE")
    private String paytype;

    @Column(name = "LOANSTATUS")
    private String loanstatus;

    @Column(name = "LOANTYPE")
    private String loantype;

    @Column(name = "SALEFULLNAME")
    private String salefullname;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "FEEOVD")
    private Integer feeOvd;

    @Column(name = "TOTAL")
    private Integer total;

    @Column(name = "PREPAYMENTFEE")
    private Integer prePaymentFee;
}
