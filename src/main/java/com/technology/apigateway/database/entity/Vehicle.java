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
@Table(name = "VEHICLE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Vehicle.getAllVehicle", procedureName = "pck_vehicle.get_all_vehicle", resultClasses = Vehicle.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        }),
        @NamedStoredProcedureQuery(name = "Vehicle.getVehicleByCompanyId", procedureName = "pck_vehicle.get_vehicle_by_CompanyId", resultClasses = Vehicle.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_companyId", mode = ParameterMode.IN, type = int.class)
        })
})
public class Vehicle {
    // tên phương tiện SH, wave , lead
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COMPANYID")
    private int companyId;


}
