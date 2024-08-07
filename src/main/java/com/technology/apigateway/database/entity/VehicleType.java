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
@Table(name = "VEHICLETYPE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "VehicleType.getAllVehicleType", procedureName = "pck_vehicle.get_all_vehicleType", resultClasses = VehicleType.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        })
})
public class VehicleType {
    // kiểu phương tiện - ô tô - xe máy
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private int type;

}
