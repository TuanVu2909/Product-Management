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

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "OperatorEstPayment.operatorEstPayment", procedureName = "pck_report.operatorEstPayment", resultClasses = OperatorEstPayment.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_documentNo", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_fromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_toDate", mode = ParameterMode.IN, type = String.class),
        })
})
public class OperatorEstPayment {
    @Id
    @Column(name = "LOANSCHEDULEID")
    private int loanscheduleId;

    @Column(name = "FULLNAME")
    private String fullname;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "IDNUMBER")
    private String idnumber;

    @Column(name = "DOCUMENTNO")
    private String documentno;

    @Column(name = "DUEDATE")
    private Date duedate;

    @Column(name = "PRINNML")
    private Integer prinnml;

    @Column(name = "ESTINT")
    private Integer estint;

    @Column(name = "ESTPRIN")
    private Integer estprin;

    @Column(name = "DUENO")
    private Integer dueno;

    @Column(name = "SALE")
    private String sale;

    @Column(name = "BRANCH")
    private String branch;
}
