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
@Table(name = "DISTRICT")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "District.getAllDistrict", procedureName = "pck_authentication.get_all_district", resultClasses = District.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        }),
        @NamedStoredProcedureQuery(name = "District.getDistrictByPid", procedureName = "pck_authentication.get_district_by_pid", resultClasses = District.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_pid", mode = ParameterMode.IN, type = int.class)
        })
})
public class District {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DNAME")
    private String dName;

    @Column(name = "EN_NAME")
    private String enName;

    @Column(name = "DLEVEL")
    private String dLevel;

    @Column(name = "pid")
    private int pid;
}
