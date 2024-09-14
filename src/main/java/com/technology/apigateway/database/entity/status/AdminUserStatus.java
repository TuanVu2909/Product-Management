package com.technology.apigateway.database.entity.status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "AdminUserStatus.updateUser", procedureName = "pck_authentication.update_user", resultClasses = AdminUserStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = String.class),
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

        })
})
public class AdminUserStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
