package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("tokenRepository")
public interface TokenRepository extends CrudRepository<User, Integer> {

    @Query(value = "select id, username, password, partner, time_expired from api_token where username = ?1", nativeQuery = true)
    User findByUsername(String username);

}
