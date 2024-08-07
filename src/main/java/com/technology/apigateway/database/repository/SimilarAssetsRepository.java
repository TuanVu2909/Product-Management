package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.SimilarAssets;

@Repository("similarAssetsRepository")
public interface SimilarAssetsRepository extends CrudRepository<SimilarAssets, Integer> {

    List<SimilarAssets> findByUserId(int userId);;

}