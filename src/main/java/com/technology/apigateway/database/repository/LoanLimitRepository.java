package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.ListLoanLimit;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loanLimitRepository")
public interface LoanLimitRepository extends CrudRepository<ListLoanLimit, Integer> {

    @Procedure("ListLoanLimit.getListLoanLimit")
    List<ListLoanLimit> getListLoanLimit(@Param("pv_custId") Integer custId);
}
