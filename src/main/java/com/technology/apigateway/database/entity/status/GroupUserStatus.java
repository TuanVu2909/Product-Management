package com.technology.apigateway.database.entity.status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQuery(name = "GroupUserStatus.createGroupUser", procedureName = "pck_authentication.create_group_user", resultClasses = GroupUserStatus.class, parameters = {
        @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
        @StoredProcedureParameter(name = "pv_name", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_region", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_area", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_branch", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_role", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_gfid", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_description", mode = ParameterMode.IN, type = String.class)
})
public class GroupUserStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}