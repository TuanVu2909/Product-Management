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
@Table(name = "PROVINCE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Province.getAllProvince", procedureName = "pck_authentication.get_all_province", resultClasses = Province.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        })
})
public class Province {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "PNAME")
    private String pName;

    @Column(name = "EN_NAME")
    private String enName;

    @Column(name = "PLEVEL")
    private String pLevel;

    @Column(name = "SHORT_NAME")
    private String shortName;
}
