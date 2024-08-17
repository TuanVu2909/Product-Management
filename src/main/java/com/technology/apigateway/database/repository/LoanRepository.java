package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.ListLoan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loanRepository")
public interface LoanRepository extends CrudRepository<ListLoan, Integer> {

    @Procedure("ListLoan.getLoanList")
    List<ListLoan> getLoanList(@Param("pv_id") Integer id,
                               @Param("pv_custId") Integer custId,
                               @Param("pv_fullName") String fullName,
                               @Param("pv_lnFromDate") String lnFromDate,
                               @Param("pv_lnToDate") String lnToDate,
                               @Param("pv_term") Integer term,
                               @Param("pv_rate") Integer rate,
                               @Param("pv_rateOvd") Integer rateOvd,
                               @Param("pv_feeRate") Integer feeRate,
                               @Param("pv_status") String status,
                               @Param("pv_payType") String payType,
                               @Param("pv_termType") String termType,
                               @Param("pv_loanStatus") String loanStatus,
                               @Param("pv_saleid") Integer saleId);

    @Query(value = "select l.id, l.custid, c.fullname, l.lndate, l.amount, l.term, l.rate, l.feerate, l.rateovd, l.prinnml, l.prinovd, l.lnclass, l.intnml, " +
            "l.intovd, l.assetmanagementfee, l.assetmanagementovd, l.status, l.paytype, l.termtype, l.createddate, ' ' loanstatus,  c.idnumber, " +
            "l.regid, c.mobile, l.documentno, l.insurancefee, l.guaranteetranfee, null salename, null branch, null expertisefeerate, null outstandingamount, null prepaymentfee from loan l, customer c where l.custid = c.id and l.regid = ?1", nativeQuery = true)
    List<ListLoan> findByRegId(Integer regId);
}
