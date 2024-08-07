package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.Region;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("regionRepository")
public interface RegionRepository extends CrudRepository<Region, String> {

    @Procedure("Region.getAllRegion")
    List<Region> getAllRegion();

}
