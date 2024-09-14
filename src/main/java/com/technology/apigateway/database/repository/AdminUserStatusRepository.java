package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.status.AdminUserStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository("adminUserStatusRepository")
public interface AdminUserStatusRepository extends CrudRepository<AdminUserStatus, String> {

    @Procedure("AdminUserStatus.updateUser")
    AdminUserStatus updateUser(@Param("pv_userid") String userId,
                               @Param("pv_username") String username,
                               @Param("pv_password") String password,
                               @Param("pv_fullname") String fullName,
                               @Param("pv_idcode") String idCode,
                               @Param("pv_idplace") String idPlace,
                               @Param("pv_dob") Date dob,
                               @Param("pv_sex") String sex,
                               @Param("pv_phone") String phone,
                               @Param("pv_email") String email,
                               @Param("pv_role") String role,
                               @Param("pv_branch") String branch,
                               @Param("pv_gid") String gid);
}
