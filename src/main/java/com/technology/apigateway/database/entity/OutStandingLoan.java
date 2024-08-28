package com.technology.apigateway.database.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    @Column(name = "USERID")
    int userId;

    @Column(name = "FULLNAME")
    String fullName;

    @Column(name = "BRANCH")
    String branch;

    @Column(name = "PRINNML")
    String prinnml;

    @Column(name = "BUSINESSDATE")
    String businessdate;

}
