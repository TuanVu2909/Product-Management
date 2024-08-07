package com.technology.apigateway.database.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.ChangePassword;


@Repository("changePasswordRepository")
public interface ChangePasswordRepository extends CrudRepository<ChangePassword, String> {

    @Procedure("ChangePassword.changePassword")
    ChangePassword changePassword(@Param("pv_userid") Integer userId,
            @Param("pv_currentPassword") String currentPassword,
            @Param("pv_newPassword") String newPassword,
            @Param("pv_confirmNewPassword") String confirmNewPassword);
}
