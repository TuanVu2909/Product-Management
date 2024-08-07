package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.Vehicle;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vehicleRepository")
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    @Procedure(name = "Vehicle.getAllVehicle")
    List<Vehicle> getAllVehicle();

    @Procedure(name = "Vehicle.getVehicleByCompanyId")
    List<Vehicle> getVehicleByCompanyId(@Param("pv_companyId") int companyId);
}
