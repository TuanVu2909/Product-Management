package com.technology.apigateway.database.entity;

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
@NamedStoredProcedureQuery(name = "GroupFunctionStatus.createGroupFunction", procedureName = "pck_authentication.create_group_function", resultClasses = GroupFunctionStatus.class, parameters = {
        @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
        @StoredProcedureParameter(name = "pv_name", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "pv_functions", mode = ParameterMode.IN, type = String.class)
})
public class GroupFunctionStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
