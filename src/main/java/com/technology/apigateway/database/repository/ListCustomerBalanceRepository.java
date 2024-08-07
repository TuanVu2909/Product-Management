package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.ListCustomerBalance;

@Repository("listCustomerBalanceRepository")
public interface ListCustomerBalanceRepository extends CrudRepository<ListCustomerBalance, Integer> {

    @Procedure("ListCustomerBalance.getListCustomerBalance")
    List<ListCustomerBalance> getListCustomerBalance();
}
