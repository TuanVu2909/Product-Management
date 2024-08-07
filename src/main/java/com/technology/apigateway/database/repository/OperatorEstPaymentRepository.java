package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.OperatorEstPayment;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("operatorEstPaymentRepository")
public interface OperatorEstPaymentRepository extends CrudRepository<OperatorEstPayment, String> {

    @Procedure("OperatorEstPayment.operatorEstPayment")
    List<OperatorEstPayment> operatorEstPayment(@Param("pv_fullName") String fullName,
                                                @Param("pv_mobile") String mobile,
                                                @Param("pv_idNumber") String idNumber,
                                                @Param("pv_branch") String branch,
                                                @Param("pv_userId") Integer userId,
                                                @Param("pv_documentNo") String documentNo,
                                                @Param("pv_fromDate") String fromDate,
                                                @Param("pv_toDate") String toDate);
}
