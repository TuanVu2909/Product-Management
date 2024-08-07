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
@Table(name = "FUNCTION")
@NamedStoredProcedureQueries({ //
        @NamedStoredProcedureQuery(name = "Function.getAllFunction", procedureName = "pck_authentication.get_all_function", resultClasses = Function.class, parameters = { //
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
                // @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type =
                // String.class)
        }), //
        @NamedStoredProcedureQuery(name = "Function.getFunctionByUserId", procedureName = "pck_authentication.get_function_by_userid", resultClasses = Function.class, parameters = { //
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = String.class)
        }),
})
public class Function {
    @Id
    @Column(name = "FUNCTION_ID")
    private String functionId;

    @Column(name = "FUNCTION_NAME")
    private String functionName;

    @Column(name = "STATUS")
    private int status;
}
