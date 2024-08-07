package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.IncomeEntity;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("incomeRepository")
public interface IncomeRepository extends CrudRepository<IncomeEntity, Integer> {

    List<IncomeEntity> findByUserId(int userId);

    @Procedure("IncomeEntity.getCustomerIncome")
    List<IncomeEntity> getCustomerIncome(@Param("pv_userId") Integer userId,
                                         @Param("pv_incomeType") String incomeType);

}
