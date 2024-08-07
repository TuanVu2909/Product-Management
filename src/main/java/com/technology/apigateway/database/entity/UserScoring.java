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
                @NamedStoredProcedureQuery(name = "UserScoring.getScoring", procedureName = "pck_customer.getScoring", resultClasses = UserScoring.class, parameters = {
                                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class)
                })
})

public class UserScoring {
        
        @Id
        @Column(name = "USERID")
        private int  userId;
        @Column(name = "PROFESSION")
        private String  profession;
        @Column(name = "AGE")
        private String  age;
        @Column(name = "RESIDENCY")
        private String  residency;
        @Column(name = "RESIDENCYTIME")
        private String  residencyTime;
        @Column(name = "MARITALSTATUS")
        private String  maritalStatus;
        @Column(name = "DEPEDENCY")
        private String  depedency;
        @Column(name = "RELWITHFINY")
        private String  relWithFiny;
        @Column(name = "INCOMEPROVETYPE")
        private String  incomeProveType;
        @Column(name = "INCOME")
        private String  income;
        @Column(name = "WORKINGTIME")
        private String  workingTime;
        @Column(name = "INSURANCE")
        private String  insurance;
        @Column(name = "ASSETTYPE")
        private String  assetType;
        @Column(name = "ASSETVALUE")
        private String  assetValue;
        @Column(name = "ASSETUSEFOR")
        private String  assetUseFor;

}
