package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.status.GroupUserStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("groupUserStatusRepository")
public interface GroupUserStatusRepository extends CrudRepository<GroupUserStatus, String> {
    @Procedure("GroupUserStatus.createGroupUser")
    GroupUserStatus createGroupUser(@Param("pv_name") String name,
                                    @Param("pv_region") String region,
                                    @Param("pv_area") String area,
                                    @Param("pv_branch") String branch,
                                    @Param("pv_role") String role,
                                    @Param("pv_gfid") String gfId,
                                    @Param("pv_description") String description);
}
