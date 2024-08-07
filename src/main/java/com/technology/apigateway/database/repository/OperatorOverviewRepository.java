package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.OperatorOverview;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("operatorOverviewRepository")
public interface OperatorOverviewRepository extends CrudRepository<OperatorOverview, Integer> {
    @Procedure("OperatorOverview.operatorOverview")
    List<OperatorOverview> operatorOverview(@Param("pv_userId") int userid);
}
