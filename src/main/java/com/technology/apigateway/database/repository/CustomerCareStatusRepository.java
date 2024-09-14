package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.status.CustomerCareStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository("customerCareStatusRepository")
public interface CustomerCareStatusRepository extends CrudRepository<CustomerCareStatus, String> {

    @Procedure("CustomerCareStatus.createCustomerCare")
    CustomerCareStatus createCustomerCare(@Param("pv_custid") int custId,
                                          @Param("pv_careid") String careId,
                                          @Param("pv_caretype") String careType);
                                          //@Param("pv_createddate") Date createdDate);

    @Procedure("CustomerCareStatus.updateCustomerCare")
    CustomerCareStatus updateCustomerCare(@Param("pv_id") int id,
                                          @Param("pv_custid") int custId,
                                          @Param("pv_careid") String careId,
                                          @Param("pv_caretype") String careType,
                                          @Param("pv_createddate") Date createdDate);
}
