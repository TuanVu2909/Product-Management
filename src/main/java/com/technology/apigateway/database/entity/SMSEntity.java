package com.technology.apigateway.database.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "SMSEntity.findSMSMobile",
                procedureName = "pck_authentication.get_all_sms",
                resultClasses = SMSEntity.class,
                parameters = {
                        @StoredProcedureParameter(name = "pv_cursor",        mode = ParameterMode.REF_CURSOR, type = Void.class)
                }
        ),

})
@Table(name = "sms")
public class SMSEntity {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "TOMOBILE")
    private String toMobile;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "STATUS")
    private int status;

}
