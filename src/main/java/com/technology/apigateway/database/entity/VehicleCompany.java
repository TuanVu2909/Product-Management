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
@Table(name = "VEHICLECOMPANY")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "VehicleCompany.getAllVehicleCompany", procedureName = "pck_vehicle.get_all_vehicleCompany", resultClasses = VehicleCompany.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        }),
        @NamedStoredProcedureQuery(name = "VehicleCompany.getCompanyByType", procedureName = "pck_vehicle.get_company_by_TypeId", resultClasses = VehicleCompany.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_typeId", mode = ParameterMode.IN, type = int.class)
        })
})
public class VehicleCompany {
    // hãng phương tiện - honda - yamaha - sym - suzuki
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPEID")
    private int typeId;

}
