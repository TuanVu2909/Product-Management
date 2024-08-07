package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.OperatorLoan;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("operatorLoanRepository")
public interface OperatorLoanRepository extends CrudRepository<OperatorLoan, String> {

    @Procedure("OperatorLoan.operatorLoan")
    List<OperatorLoan> operatorLoan(@Param("pv_id")Integer id,
                                    @Param("pv_custId") Integer custId,
                                    @Param("pv_fullName") String fullName,
                                    @Param("pv_mobile") String mobile,
                                    @Param("pv_idNumber") String idNumber,
                                    @Param("pv_loanType") String loanType,
                                    @Param("pv_term") Integer term,
                                    @Param("pv_rate") Integer rate,
                                    @Param("pv_rateOvd") Integer rateOvd,
                                    @Param("pv_feeRate") Integer feeRate,
                                    @Param("pv_status") String status,
                                    @Param("pv_payType") String payType,
                                    @Param("pv_termType") String termType,
                                    @Param("pv_loanStatus") String loanStatus,
                                    @Param("pv_saleId") Integer saleId,
                                    @Param("pv_saleFullName") String saleFullName,
                                    @Param("pv_lnFromDate") String lnFromDate,
                                    @Param("pv_lnToDate") String lnToDate);
}
