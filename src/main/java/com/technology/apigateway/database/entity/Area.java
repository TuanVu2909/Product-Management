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
@Table(name = "AREA")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Area.getAllArea", procedureName = "pck_authentication.get_all_area", resultClasses = Area.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        })
})
public class Area {
    @Id
    @Column(name = "AID")
    private String aid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RID")
    private String rid;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private int status;
}
