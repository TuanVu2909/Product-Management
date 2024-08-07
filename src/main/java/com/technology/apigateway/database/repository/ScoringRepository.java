package com.technology.apigateway.database.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.Scoring;

@Repository("scoringRepository")
public interface ScoringRepository extends CrudRepository<Scoring, Integer> {

    @Procedure("Scoring.getScoringCal")
    Scoring getScoringCal(@Param("pv_userid") int userId);

}
