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
@Table(name = "WARD")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Ward.getAllWard", procedureName = "pck_authentication.get_all_ward", resultClasses = Ward.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        }),
        @NamedStoredProcedureQuery(name = "Ward.getWardByDid", procedureName = "pck_authentication.get_ward_by_did", resultClasses = Ward.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_did", mode = ParameterMode.IN, type = int.class)
        })
})
public class Ward {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "WNAME")
    private String wName;

    @Column(name = "EN_NAME")
    private String enName;

    @Column(name = "WLEVEL")
    private String wLevel;

    @Column(name = "DID")
    private int did;
}
