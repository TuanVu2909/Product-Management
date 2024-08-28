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
        @NamedStoredProcedureQuery(name = "OperatorTransaction.operatorTransaction", procedureName = "pck_report.operatorTransaction", resultClasses = OperatorTransaction.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_tranName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_tranDes", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_fromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_toDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
        })
})
public class OperatorTransaction {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "IDNUMBER")
    private String idNumber;

    @Column(name = "BNAME")
    private String bname;

    @Column(name = "TRANDATE")
    private Date tranDate;

    @Column(name = "TRANNAME")
    private String tranName;

    @Column(name = "TRANVALUE")
    private Integer tranValue;

    @Column(name = "TRANDES")
    private String tranDes;

    @Column(name = "DUENO")
    private Integer dueno;
}
