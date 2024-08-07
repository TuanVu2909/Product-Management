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
        @NamedStoredProcedureQuery(name = "SaleOverview.saleOverview", procedureName = "pck_report.saleOverview", resultClasses = SaleOverview.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
        })
})
public class SaleOverview {
    @Id
    @Column(name = "NEEDTOADD")
    private String needToAdd;

    @Column(name = "WAITFORAPPROVE")
    private String waitForApprove;

    @Column(name = "AMTPAID")
    private String amtPaid;

    @Column(name = "AMTAVAILABLE")
    private String amtAvailable;

    @Column(name = "WAITFORRELEASE")
    private String waitForRelease;

}
