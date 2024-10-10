package com.technology.apigateway.controller.response;

import lombok.Getter;
import lombok.Setter;

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
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(name = "LoanDetailResponse.getLoanDetail", procedureName = "pck_loan.getLoanDetail", resultClasses = LoanDetailResponse.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
        })
)

public class LoanDetailResponse {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DOCUMENTNO")
    private String documentno;

    @Column(name = "LNDATE")
    private String lndate;

    @Column(name = "PRINNML")
    private Double prinnml;

    @Column(name = "PRINOVD")
    private Double prinovd;

    @Column(name = "INTNML")
    private Double intnml;

    @Column(name = "INTOVD")
    private Double intovd;

    @Column(name = "ASSETMANAGEMENTFEE")
    private Double assetmanagementfee;

    @Column(name = "ASSETMANAGEMENTOVD")
    private Double assetmanagementovd;

    @Column(name = "EXPERTISEFEE")
    private Double expertisefee;

    @Column(name = "EXPERTISEFEEOVD")
    private Double expertisefeeovd;

    @Column(name = "FEEOVD")
    private Double feeovd;

    @Column(name = "CUSTID")
    private Double custid;

    @Column(name = "FULLNAME")
    private String fullname;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "PREPAYMENTFEE")
    private String prepaymentfee;
}
