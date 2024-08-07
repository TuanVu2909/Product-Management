package com.technology.apigateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "GROUP_FUNCTION")
@NamedStoredProcedureQueries({ //
        @NamedStoredProcedureQuery(name = "GroupFunction.getAllGroupFunction", procedureName = "pck_authentication.get_all_group_function", resultClasses = GroupFunction.class, parameters = { //
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
                // @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type =
                // String.class)
        }),//
})
public class GroupFunction {
    @Id
    @Column(name = "GFID")
    private String gfId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FUNCTIONS")
    private String functions;

//    @Column(name = "STATUS")
//    private int status;

}
