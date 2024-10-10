package com.technology.apigateway.database.entity.status;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


@Entity
@Getter
@Setter
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(name = "BatchStatus.runBatch", procedureName = "pck_batch.runBatch", resultClasses = BatchStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
        })
)
public class BatchStatus {

    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
