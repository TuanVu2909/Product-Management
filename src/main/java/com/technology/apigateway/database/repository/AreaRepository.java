package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.Area;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("areaRepository")
public interface AreaRepository extends CrudRepository<Area, String> {

    @Procedure("Area.getAllArea")
    List<Area> getAllArea();
}
