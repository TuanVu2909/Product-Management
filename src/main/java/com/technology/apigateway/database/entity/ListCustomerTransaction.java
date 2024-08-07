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
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "ListCustomerTransaction.getListTransactions", procedureName = "pck_customer.getListTransactions", resultClasses = ListCustomerTransaction.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
}))
public class ListCustomerTransaction {
        @Id
        @Column(name = "ID")
        private Integer id;

        @Column(name = "FULLNAME")
        private String fullName;

        @Column(name = "MOBILE")
        private String mobile;

        @Column(name = "IDNUMBER")
        private String idNumber;

        @Column(name = "TRANVALUE")
        private String tranValue;

        @Column(name = "TRANDES")
        private String tranDes;

        @Column(name = "CREATEDDATE")
        private String createdDate;

        @Column(name = "STATUS")
        private String status;

        @Column(name = "STATUSDES")
        private String statusDes;

}
