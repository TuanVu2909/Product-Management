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
        @NamedStoredProcedureQuery(name = "CalculatorStatus.finalCalPrice", procedureName = "pck_vehicle.finalCalPrice", resultClasses = CalculatorStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_vehicleid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_vehicleage", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_bt", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_dbm", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_dkmn", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_rrdn", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_bdmm", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_tngt", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_tk", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_dnnv", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_sx", mode = ParameterMode.IN, type = int.class),
        })
})
public class CalculatorStatus {

    @Id
    @Column(name = "TOTALDEC")
    private String totalDec;

    @Column(name = "FINYPRICE")
    private String finyPrice;

    @Column(name = "BTPRICE")
    private String btPrice;

    @Column(name = "DBM")
    private String dbm;

    @Column(name = "DKMN")
    private String dkmn;

    @Column(name = "RRDN")
    private String rrdn;

    @Column(name = "BDMM")
    private String bdmm;

    @Column(name = "TNGT")
    private String tngt;

    @Column(name = "TK")
    private String tk;

    @Column(name = "DNNV")
    private String dnnv;

    @Column(name = "SX")
    private String sx;
}
