package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.AdminUser;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("userRepository")
public interface AdminUserRepository extends CrudRepository<AdminUser, String> {

    @Procedure("AdminUser.getByUserName")
    AdminUser getByUserName(@Param("pv_username") String userId);

    @Procedure("AdminUser.getAdminUserById")
    List<AdminUser> getAdminUserById(@Param("pv_userid") int userid);

    List<AdminUser> findAll();

    @Procedure("AdminUser.getAllAdminUser")
    List<AdminUser> getAllAdminUser();

    @Procedure("AdminUser.createUser")
    AdminUser createUser(@Param("pv_username") String username,
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
