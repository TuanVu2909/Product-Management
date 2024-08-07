package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ADMIN_USER")
@NamedQuery(name = "AdminUser.findAll", query = "SELECT a FROM AdminUser a")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "AdminUser.createUser", procedureName = "pck_authentication.create_user", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_username", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_password", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_fullname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idcode", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idplace", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_dob", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_sex", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_phone", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_email", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_role", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_gid", mode = ParameterMode.IN, type = String.class),
        }),
        @NamedStoredProcedureQuery(name = "AdminUser.updateUser", procedureName = "pck_authentication.update_user", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_username", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_password", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_fullname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idcode", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idplace", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_dob", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_sex", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_phone", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_email", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_role", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_gid", mode = ParameterMode.IN, type = String.class),

        }),

        @NamedStoredProcedureQuery(name = "AdminUser.getAllAdminUser", procedureName = "pck_authentication.get_all_admin_user", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        }),

        @NamedStoredProcedureQuery(name = "AdminUser.getAdminUserById", procedureName = "pck_authentication.get_admin_user_by_id", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class)
        }),

        @NamedStoredProcedureQuery(name = "AdminUser.getByUserName", procedureName = "pck_authentication.get_admin_by_username", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_username", mode = ParameterMode.IN, type = String.class),
        }),
        @NamedStoredProcedureQuery(name = "AdminUser.saleOverview", procedureName = "pck_report.saleOverview", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = int.class)
        }),
        @NamedStoredProcedureQuery(name = "AdminUser.operatorOverview", procedureName = "pck_report.operatorOverview", resultClasses = AdminUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = int.class)
        })

})
public class AdminUser {
    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "ID_CODE")
    private String idCode;

    @Column(name = "ID_PLACE")
    private String idPlace;

    @Column(name = "BIRTH_DATE")
    private Date dob;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOGIN_FAIL")
    private int loginFail;

    @Column(name = "REGISTER_DATE")
    private Date regDate;

    @Column(name = "WHO_CREATED")
    private String whoCreated;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "GID")
    private String gid;

    @Column(name = "BRANCHNAME")
    private String branchName;

    @Column(name = "BRANCHADDRESS")
    private String branchAddress;
}
