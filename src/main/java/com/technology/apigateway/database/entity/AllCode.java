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
@Table(name = "ALLCODE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "AllCode.getAllAllCode", procedureName = "pck_authentication.get_all_allcode", resultClasses = AllCode.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        }),
        @NamedStoredProcedureQuery(name = "AllCode.getAllCodeByType", procedureName = "pck_authentication.get_allcode_by_type", resultClasses = AllCode.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_type", mode = ParameterMode.IN, type = String.class)
        })

})
public class AllCode {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "LSTORDER")
    private int lstOrder;

    @Column(name = "STATE")
    private int state;

}
