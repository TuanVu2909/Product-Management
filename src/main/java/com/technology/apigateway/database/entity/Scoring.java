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
                @NamedStoredProcedureQuery(name = "Scoring.getScoring", procedureName = "pck_customer.getScoring", resultClasses = Scoring.class, parameters = {
                                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class)
                }),

                @NamedStoredProcedureQuery(name = "Scoring.getScoringCal", procedureName = "pck_customer.getScoringCal", resultClasses = Scoring.class, parameters = {
                                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class)
                })
})

public class Scoring {
        
        @Id
        @Column(name = "USERID")
        private int userId;
        @Column(name = "PROFESSION")
        private int profession;
        @Column(name = "AGE")
        private int age;
        @Column(name = "RESIDENCY")
        private int residency;
        @Column(name = "RESIDENCYTIME")
        private int residencyTime;
        @Column(name = "MARITALSTATUS")
        private int maritalStatus;
        @Column(name = "DEPEDENCY")
        private int depedency;
        @Column(name = "RELWITHFINY")
        private int relWithFiny;
        @Column(name = "INCOMEPROVETYPE")
        private int incomeProveType;
        @Column(name = "INCOME")
        private int income;
        @Column(name = "WORKINGTIME")
        private int workingTime;
        @Column(name = "INSURANCE")
        private int insurance;
        @Column(name = "ASSETTYPE")
        private int assetType;
        @Column(name = "ASSETVALUE")
        private int assetValue;
        @Column(name = "ASSETUSEFOR")
        private int assetUseFor;
        @Column(name = "TOTALPOINT")
        private int totalPoint;

}
