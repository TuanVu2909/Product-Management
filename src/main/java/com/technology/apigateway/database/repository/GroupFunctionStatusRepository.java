package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.GroupFunctionStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("groupFunctionStatusRepository")
public interface GroupFunctionStatusRepository extends CrudRepository<GroupFunctionStatus, String> {

    @Procedure("GroupFunctionStatus.createGroupFunction")
    GroupFunctionStatus createGroupFunction(@Param("pv_name") String name,
                                            @Param("pv_functions") String functions);
}
