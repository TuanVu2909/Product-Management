package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.BusinessDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("businessDateRepository")
public interface BusinessDateRepository extends CrudRepository<BusinessDate, Long> {

    @Query(value = "select * from businessdate where datetype = :currentDate", nativeQuery = true)
    List<BusinessDate> getBusinessDate(@Param("currentDate") String currentDate);
}
