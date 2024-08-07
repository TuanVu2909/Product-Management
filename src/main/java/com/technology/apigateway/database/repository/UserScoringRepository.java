package com.technology.apigateway.database.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.UserScoring;

@Repository("userScoringRepository")
public interface UserScoringRepository extends CrudRepository<UserScoring, Integer> {

    @Procedure("UserScoring.getScoring")
    UserScoring getScoring(@Param("pv_userid") int userId);

}
