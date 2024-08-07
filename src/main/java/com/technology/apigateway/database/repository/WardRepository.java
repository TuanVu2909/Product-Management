package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.Ward;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wardRepository")
public interface WardRepository extends CrudRepository<Ward, Integer> {

    @Procedure(name = "Ward.getAllWard")
    List<Ward> getAllWard();

    @Procedure(name = "Ward.getWardByDid")
    List<Ward> getWardByDid(@Param("pv_did") int did);
}
