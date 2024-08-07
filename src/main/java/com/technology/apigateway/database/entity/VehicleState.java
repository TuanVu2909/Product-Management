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

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "VehicleState.getVehicleState", procedureName = "pck_vehicle.getVehicleState", resultClasses = VehicleState.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.IN, type = String.class),
        })
})
public class VehicleState {
    @Id
    @Column(name = "STATECODE")
    private String stateCode;

    @Column(name = "STATENAME")
    private String stateName;
}
