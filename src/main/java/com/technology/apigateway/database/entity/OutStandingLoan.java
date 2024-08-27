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

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "OutStandingLoan.outStandingLoan", procedureName = "pck_report.outstandingLoan", resultClasses = OutStandingLoan.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_fromDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_toDate", mode = ParameterMode.IN, type = String.class),
        })
})
public class OutStandingLoan {
    @Id
    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "PRINNML")
    private String prinnml;

    @Column(name = "BUSINESSDATE")
    private String businessdate;




}
