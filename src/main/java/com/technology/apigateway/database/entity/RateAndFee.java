package com.technology.apigateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "RATEANDFEE")
@NamedQuery(name = "RateAndFee.findAll", query = "SELECT a FROM RateAndFee a")
public class RateAndFee {
        @Id
        @Column(name = "ID")
        private int id;

        @Column(name = "RAFTYPE")
        private String rafType;

        @Column(name = "RAFVAL")
        private String rafVal;

        @Column(name = "TERM")
        private String term;

        @Column(name = "CREATEDDATE")
        private String createdDate;

        @Column(name = "APPLYDATE")
        private String applyDate;

        @Column(name = "VALTYPE")
        private String valType;

        @Column(name = "LOANTYPE")
        private String loanType;

}
