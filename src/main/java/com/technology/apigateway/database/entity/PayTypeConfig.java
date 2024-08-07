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
public class PayTypeConfig {
        @Id
        @Column(name = "ID")
        private int id;

        @Column(name = "LOANTYPE")
        private String loanType;

        @Column(name = "TERMTYPE")
        private String termType;

        @Column(name = "PAYTYPE")
        private String payType;

        @Column(name = "CREATEDDATE")
        private String createdDate;

        @Column(name = "APPLYDATE")
        private String applyDate;

        @Column(name = "NAME")
        private String name;

}
