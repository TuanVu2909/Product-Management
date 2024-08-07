package com.technology.apigateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
                @NamedStoredProcedureQuery(name = "AddComment.addComment", procedureName = "pck_loan.addComment", resultClasses = AddComment.class, parameters = {
                                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = Integer.class),
                                @StoredProcedureParameter(name = "pv_loanid", mode = ParameterMode.IN, type = Integer.class),
                                @StoredProcedureParameter(name = "pv_comment", mode = ParameterMode.IN, type = String.class)
                })
})
public class AddComment {
        @Id
        @Column(name = "pv_status")
        private String status;

        @Column(name = "pv_des")
        private String description;
}
