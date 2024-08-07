package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.District;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("districtRepository")
public interface DistrictRepository extends CrudRepository<District, Integer> {

    @Procedure(name = "District.getAllDistrict")
    List<District> getAllDistrict();

    @Procedure(name = "District.getDistrictByPid")
    List<District> getDistrictsByPid(@Param("pv_pid") int pid);
}
