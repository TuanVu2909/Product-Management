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
@Table(name = "BRANCH")
@NamedStoredProcedureQueries({ //
        @NamedStoredProcedureQuery(name = "Branch.getBranchByUserId", procedureName = "pck_authentication.get_branch_by_userid", resultClasses = Branch.class, parameters = { //
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = String.class)
        }), //
        @NamedStoredProcedureQuery(name = "Branch.getAllBranch", procedureName = "pck_authentication.get_all_branch", resultClasses = Branch.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)

        })
})
public class Branch {
    @Id
    @Column(name = "BID")
    private String bid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AID")
    private String aid;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "RID")
    private String rid;

    @Column(name = "FULL_ADDRESS")
    private String fullAddress;
}
