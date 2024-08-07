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
                @NamedStoredProcedureQuery(name = "UserComment.getAllCommentByLoanRegId", procedureName = "pck_loan.getAllCommentByLoanRegId", resultClasses = UserComment.class, parameters = {
                                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                                @StoredProcedureParameter(name = "pv_loanid", mode = ParameterMode.IN, type = Integer.class)
                })
})
public class UserComment {

        @Id
        @Column(name = "ID")
        private int id;

        @Column(name = "USERID")
        private int userId;

        @Column(name = "LOANREGID")
        private String loanRegId;

        @Column(name = "LOGDATE")
        private String logDate;

        @Column(name = "STATUS")
        private int status;

        @Column(name = "COMMENTDETAIL")
        private String commentDetail;

        @Column(name = "FULLNAME")
        private String fullName;

        @Column(name = "ROLE")
        private String role;

}
