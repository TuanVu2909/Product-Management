package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.Function;

@Repository("functionRepository")
public interface FunctionRepository extends CrudRepository<Function, String> {

    @Procedure("Function.getAllFunction")
    List<Function> getAllFunction();

//    @Procedure("Function.getFunctionByUserId")
//    List<Function> getFunctionByUserId(@Param("pv_userid")String userId);

}
