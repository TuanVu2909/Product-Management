package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.GroupUser;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("groupUserRepository")
public interface GroupUserRepository extends CrudRepository<GroupUser, String> {

    GroupUser findByGid(String userId);

    @Procedure("GroupUser.getAllGroupUser")
    List<GroupUser> getAllGroupUser();


}
