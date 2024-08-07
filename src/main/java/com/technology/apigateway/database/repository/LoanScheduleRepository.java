package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.LoanSchedule;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loanScheduleRepository")
public interface LoanScheduleRepository extends CrudRepository<LoanSchedule, Integer> {

    @Procedure("LoanSchedule.getLoanScheduleByLoanId")
    List<LoanSchedule> getLoanScheduleByLoanId(@Param("pv_loanId") int loanId);
}
