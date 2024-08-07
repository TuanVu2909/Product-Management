package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.OperatorLoanSchedule;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("operatorLoanScheduleRepository")
public interface OperatorLoanScheduleRepository extends CrudRepository<OperatorLoanSchedule, String> {

    @Procedure("OperatorLoanSchedule.operatorLoanSchedule")
    List<OperatorLoanSchedule> operatorLoanSchedule(@Param("pv_loanId") Integer loanId,
                                                    @Param("pv_loanScheduleId") Integer loanScheduleId,
                                                    @Param("pv_custId") Integer custId,
                                                    @Param("pv_fullName") String fullName,
                                                    @Param("pv_mobile") String mobile,
                                                    @Param("pv_idNumber") String idNumber,
                                                    @Param("pv_branch") String branch,
                                                    @Param("pv_payType") String payType,
                                                    @Param("pv_loanStatus") String loanStatus,
                                                    @Param("pv_loanType") String loanType,
                                                    @Param("pv_saleFullName") String saleFullName,
                                                    @Param("pv_lnFromDate") String lnFromDate,
                                                    @Param("pv_lnToDate") String lnToDate);
}
