package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.LoanStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository("loanStatusRepository")
public interface LoanStatusRepository extends CrudRepository<LoanStatus, String> {

    @Procedure("LoanStatus.createLoan")
    LoanStatus createLoan(@Param("pv_regId") int pv_regId,
                          @Param("pv_custId") int custId,
                          @Param("pv_lnDate") Date lnDate,
                          @Param("pv_insuranceFee") int insuranceFee,
                          @Param("pv_guaranteeTranFee") int guaranteeTranFee,
                          @Param("pv_expertiseFeePrePaid") Double expertiseFeePrePaid,
                          @Param("pv_rate") Double rate,
                          @Param("pv_assetManagementFeeRate") Double assetManagementFeeRate,
                          @Param("pv_rateOvd") Double rateOvd,
                          @Param("pv_expertiseFeeRate") Double expertiseFeeRate,
                          @Param("pv_prePaymentFeeRate") Double prePaymentFeeRate,
                          @Param("pv_documentNo") String documentNo);

    @Procedure("LoanStatus.updateLoanStatus")
    LoanStatus updateLoanStatus(@Param("pv_loanId") int loanId,
                                @Param("pv_status") String status);

    @Procedure("LoanStatus.prePayment")
    LoanStatus prePayment(@Param("pv_loanId") int loanId,
                          @Param("pv_userId") int userId);

    @Procedure("LoanStatus.approvePrePayment")
    LoanStatus approvePrePayment(@Param("pv_loanId") int loanId,
                                 @Param("pv_approveUserId") int approveUserId);
}
