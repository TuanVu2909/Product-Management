package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.OperatorTransaction;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("transactionOperatorRepository")
public interface TransactionOperatorRepository extends CrudRepository<OperatorTransaction, String> {

    @Procedure("OperatorTransaction.operatorTransaction")
    List<OperatorTransaction> operatorTransaction(@Param("pv_fullName") String fullName,
                                                  @Param("pv_mobile") String mobile,
                                                  @Param("pv_idNumber") String idNumber,
                                                  @Param("pv_branch") String branch,
                                                  @Param("pv_tranName") String tranName,
                                                  @Param("pv_tranDes") String tranDes,
                                                  @Param("pv_fromDate") String fromDate,
                                                  @Param("pv_toDate") String toDate);
}
