package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.ReferencesEntity;

@Repository("referencesRepository")
public interface ReferencesRepository extends CrudRepository<ReferencesEntity, Integer> {

    List<ReferencesEntity> findByUserId(int userId);

    List<ReferencesEntity> findByRegId(int regId);

}
