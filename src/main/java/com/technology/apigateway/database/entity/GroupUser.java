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
@Table(name = "GROUP_USER")
@NamedQuery(name = "GroupUser.findAll", query = "SELECT a FROM GroupUser a")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "GroupUser.getAllGroupUser", procedureName = "pck_authentication.get_all_group_user", resultClasses = GroupUser.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        })
})
public class GroupUser {
    @Id
    //@Column(name = "GID")
    private String gid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REGION")
    private String region;

    @Column(name = "AREA")
    private String area;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "GFID")
    private String gfId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "STATUS")
    private int status;

}
