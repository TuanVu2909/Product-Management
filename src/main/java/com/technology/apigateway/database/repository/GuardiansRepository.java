package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.GuardiansEntity;

@Repository("guardiansRepository")
public interface GuardiansRepository extends CrudRepository<GuardiansEntity, Integer> {

    List<GuardiansEntity> findByUserId(int userId);

}
