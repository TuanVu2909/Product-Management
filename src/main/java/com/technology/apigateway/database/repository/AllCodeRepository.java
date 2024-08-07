package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.AllCode;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("allCodeRepository")
public interface AllCodeRepository extends CrudRepository<AllCode, Integer> {

    @Procedure("AllCode.getAllAllCode")
    List<AllCode> getAllAllCode();

    @Procedure("AllCode.getAllCodeByType")
    List<AllCode> getAllCodeByType(@Param("pv_type") String type);


}
