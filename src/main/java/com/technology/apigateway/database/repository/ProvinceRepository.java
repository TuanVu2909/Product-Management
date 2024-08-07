package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.Province;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("provinceRepository")
public interface ProvinceRepository extends CrudRepository<Province, Integer> {

    @Procedure(name = "Province.getAllProvince")
    List<Province> getAllProvince();
}
