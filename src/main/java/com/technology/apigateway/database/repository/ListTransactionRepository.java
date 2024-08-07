package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.ListCustomerTransaction;

@Repository("listTransactionRepository")
public interface ListTransactionRepository extends CrudRepository<ListCustomerTransaction, Integer> {

    @Procedure("ListCustomerTransaction.getListTransactions")
    List<ListCustomerTransaction> getListTransactions();
}
