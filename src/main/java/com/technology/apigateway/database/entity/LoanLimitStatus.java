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
        @NamedStoredProcedureQuery(name = "LoanLimitStatus.createLoanLimit", procedureName = "pck_loan.createLoanLimit", resultClasses = LoanLimitStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_limitAmount", mode = ParameterMode.IN, type = int.class)
        })
})
public class LoanLimitStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
