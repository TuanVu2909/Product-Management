package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.SaleOverview;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("saleOverviewRepository")
public interface SaleOverviewRepository extends CrudRepository<SaleOverview, Integer> {

    @Procedure("SaleOverview.saleOverview")
    List<SaleOverview> saleOverview(@Param("pv_userId") int userid);
}
