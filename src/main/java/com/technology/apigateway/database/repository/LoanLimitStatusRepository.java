package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.status.LoanLimitStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("loanLimitStatusRepository")
public interface LoanLimitStatusRepository extends CrudRepository<LoanLimitStatus, String> {

    @Procedure("LoanLimitStatus.createLoanLimit")
    LoanLimitStatus createLoanLimit(@Param("pv_custId") int custId,
                                    @Param("pv_limitAmount") int limitAmount);


}
