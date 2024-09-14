package com.technology.apigateway.database.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.status.CalculatorStatus;

@Repository("calculatorRepository")
public interface CalculatorRepository extends CrudRepository<CalculatorStatus, String> {

    @Procedure(name = "CalculatorStatus.finalCalPrice")
    CalculatorStatus finalCalPrice(@Param("pv_vehicleid") int vehicleId,
                                   @Param("pv_vehicleage") int vehicleAge,
                                   @Param("pv_bt") int bt,
                                   @Param("pv_dbm") int dbm,
                                   @Param("pv_dkmn") int dkmn,
                                   @Param("pv_rrdn") int rrdn,
                                   @Param("pv_bdmm") int bdmm,
                                   @Param("pv_tngt") int tngt,
                                   @Param("pv_tk") int tk,
                                   @Param("pv_dnnv") int dnnv,
                                   @Param("pv_sx") int sx);
}
