package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.Customer;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Procedure("Customer.getAllCustomer")
    List<Customer> getAllCustomer();

    @Procedure("Customer.getCustomerWhere")
    List<Customer> getCustomerWhere(@Param("pv_careId") Integer careId,
                                    @Param("pv_idNumber") String idNumber,
                                    @Param("pv_custId") Integer custId);
}
