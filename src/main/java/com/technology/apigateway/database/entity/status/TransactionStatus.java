package com.technology.apigateway.database.entity.status;


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
        @NamedStoredProcedureQuery(name = "TransactionStatus.topUp", procedureName = "pck_money.topUp", resultClasses = TransactionStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_amount", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = int.class)
        }),
        @NamedStoredProcedureQuery(name = "TransactionStatus.withDraw", procedureName = "pck_money.withDraw", resultClasses = TransactionStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_amount", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = int.class)
        }),
        @NamedStoredProcedureQuery(name = "TransactionStatus.approveOrder", procedureName = "pck_money.approveOrder", resultClasses = TransactionStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_tranId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_approveUserId", mode = ParameterMode.IN, type = int.class)
        })
})
public class TransactionStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
