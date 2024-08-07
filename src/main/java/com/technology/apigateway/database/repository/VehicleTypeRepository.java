package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.VehicleType;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vehicleTypeRepository")
public interface VehicleTypeRepository extends CrudRepository<VehicleType, Integer> {

    @Procedure(name = "VehicleType.getAllVehicleType")
    List<VehicleType> getAllVehicleType();
}
