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
        @NamedStoredProcedureQuery(name = "OperatorOverview.operatorOverview", procedureName = "pck_report.operatorOverview", resultClasses = OperatorOverview.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
        })
})
public class OperatorOverview {
    @Id
    @Column(name = "WAITFORRELEASE")
    private String waitForRelease;

    @Column(name = "WAITFORAPPROVE")
    private String waitForApprove;

    @Column(name = "WAITFORSIGNATURE")
    private String waitForSignature;
}
