package com.technology.apigateway.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.RateAndFee;

@Repository("rateAndFeeRepository")
public interface RateAndFeeRepository extends CrudRepository<RateAndFee, Integer> {

}
