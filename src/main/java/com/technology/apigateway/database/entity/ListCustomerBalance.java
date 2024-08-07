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
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "ListCustomerBalance.getListCustomerBalance", procedureName = "pck_customer.getListCustomerBalance", resultClasses = ListCustomerBalance.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
}))
public class ListCustomerBalance {
        @Id
        @Column(name = "ID")
        private Integer id;

        @Column(name = "FULLNAME")
        private String fullName;

        @Column(name = "MOBILE")
        private String mobile;

        @Column(name = "IDNUMBER")
        private String idNumber;

        @Column(name = "BALANCE")
        private double balance;

}
