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
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "CUSTOMERCARE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "CustomerCare.getAllCustomerCare", procedureName = "pck_customer.get_all_customer_care", resultClasses = CustomerCare.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class)
        })
})
public class CustomerCare {
    @Id
    //@Column(name = "ID")
    private int id;

    @Column(name = "CUSTID")
    private int custId;

    @Column(name = "CAREID")
    private String careId;

    @Column(name = "CARETYPE")
    private String careType;

    @Column(name = "CREATEDDATE")
    private Date createdDate;
}
