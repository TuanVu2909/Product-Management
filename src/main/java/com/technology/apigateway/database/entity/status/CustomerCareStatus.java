package com.technology.apigateway.database.entity.status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "CustomerCareStatus.createCustomerCare", procedureName = "pck_customer.create_customercare", resultClasses = CustomerCareStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_custid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_careid", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_caretype", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_createddate", mode = ParameterMode.IN, type = Date.class),
        }),
        @NamedStoredProcedureQuery(name = "CustomerCareStatus.updateCustomerCare", procedureName = "pck_customer.update_customercare", resultClasses = CustomerCareStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_custid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_careid", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_caretype", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_createddate", mode = ParameterMode.IN, type = Date.class)
        })
})
public class CustomerCareStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}

