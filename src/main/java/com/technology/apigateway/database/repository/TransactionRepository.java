package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.status.TransactionStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("transactionRepository")
public interface TransactionRepository extends CrudRepository<TransactionStatus, String> {

    @Procedure("TransactionStatus.topUp")
    TransactionStatus topUp(@Param("pv_custId") int custId,
                            @Param("pv_amount") int amount,
                            @Param("pv_userId") int userId);

    @Procedure("TransactionStatus.withDraw")
    TransactionStatus withDraw(@Param("pv_custId") int custId,
                               @Param("pv_amount") int amount,
                               @Param("pv_userId") int userId);

    @Procedure("TransactionStatus.approveOrder")
    TransactionStatus approveOrder(@Param("pv_tranId") int tranId,
                                   @Param("pv_status") String status,
                                   @Param("pv_approveUserId") int approveUserId);
}
