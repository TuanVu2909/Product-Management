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
@Table(name = "LOANLIMIT")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(name = "ListLoanLimit.getListLoanLimit", procedureName = "pck_loan.getListLoanLimit", resultClasses = ListLoanLimit.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = Integer.class),
        })
)
public class ListLoanLimit {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CUSTID")
    private String custId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "LIMITAMOUNT")
    private int limitAmount;
}
