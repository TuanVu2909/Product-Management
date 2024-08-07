package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.CustomerCare;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerCareRepository")
public interface CustomerCareRepository extends CrudRepository<CustomerCare, Integer> {

    @Procedure("CustomerCare.getAllCustomerCare")
    List<CustomerCare> getAllCustomerCare();
}
