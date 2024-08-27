package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.OutStandingLoan;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("outStandingLoanRepository")
public interface OutStandingLoanRepository extends CrudRepository<OutStandingLoan, String> {

    @Procedure("OperatorEstPayment.operatorEstPayment")
    List<OutStandingLoan> outStandingLoan(@Param("pv_userId") Integer userId,
                                          @Param("pv_fullName") String fullName,
                                          @Param("pv_branch") String branch,
                                          @Param("pv_fromDate") String fromDate,
                                          @Param("pv_toDate") String toDate);
}
