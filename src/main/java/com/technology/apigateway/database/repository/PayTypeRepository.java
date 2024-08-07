package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.PayTypeConfig;

@Repository("payTypeRepository")
public interface PayTypeRepository extends CrudRepository<PayTypeConfig, Integer> {

    @Query(value = "select p.*, a.name from paytypeconf p, allcode a where p.paytype = a.code and a.type = 'PAYTYPE'", nativeQuery = true)
    List<PayTypeConfig> findAll();
}
