package com.technology.apigateway.database.entity;

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
        @NamedStoredProcedureQuery(name = "ChangePassword.changePassword", procedureName = "pck_customer.changePassword", resultClasses = ChangePassword.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_currentPassword", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_newPassword", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_confirmNewPassword", mode = ParameterMode.IN, type = String.class)
        })
})
public class ChangePassword {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
