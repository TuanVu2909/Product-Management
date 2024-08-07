package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.VehicleCompany;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vehicleCompanyRepository")
public interface VehicleCompanyRepository extends CrudRepository<VehicleCompany, Integer> {

    @Procedure(name = "VehicleCompany.getAllVehicleCompany")
    List<VehicleCompany> getAllVehicleCompany();

    @Procedure(name = "VehicleCompany.getCompanyByType")
    List<VehicleCompany> getCompanyByType(@Param("pv_typeId") int typeId);
}
