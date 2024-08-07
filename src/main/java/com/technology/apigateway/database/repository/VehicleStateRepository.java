package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.VehicleState;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vehicleStateRepository")
public interface VehicleStateRepository extends CrudRepository<VehicleState, String> {

    @Procedure("VehicleState.getVehicleState")
    List<VehicleState> getVehicleState(@Param("pv_loanType") String loanType);
}
