package com.technology.apigateway.database.repository;

import com.technology.apigateway.controller.response.LoanDetailResponse;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loanDetailRepository")
public interface LoanDetailRepository extends CrudRepository<LoanDetailResponse, Integer> {

    @Procedure("LoanDetailResponse.getLoanDetail")
    List<LoanDetailResponse> getLoanDetail(@Param("pv_id") Integer id);
}
