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
import javax.persistence.Table;


@Entity
@Getter
@Setter
@ToString
@Table(name = "REGION")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Region.getAllRegion", procedureName = "pck_authentication.get_all_region", resultClasses = Region.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        })
})
public class Region {

    @Id
    @Column(name = "RID")
    private String rid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private int status;
}
