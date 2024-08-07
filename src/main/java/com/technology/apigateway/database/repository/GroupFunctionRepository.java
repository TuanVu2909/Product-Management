package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.GroupFunction;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupFunctionRepository")
public interface GroupFunctionRepository extends CrudRepository<GroupFunction, String> {

    @Procedure("GroupFunction.getAllGroupFunction")
    List<GroupFunction> getAllGroupFunction();


}
