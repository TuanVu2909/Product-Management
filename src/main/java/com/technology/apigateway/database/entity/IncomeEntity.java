package com.technology.apigateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERINCOMES")
@NamedQuery(name = "IncomeEntity.findAll", query = "SELECT c FROM IncomeEntity c")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "IncomeEntity.getCustomerIncome", procedureName = "pck_customer.getCustomerIncome", resultClasses = IncomeEntity.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_incomeType", mode = ParameterMode.IN, type = String.class)
        })
})
public class IncomeEntity {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "COMPANYNAME")
    private String companyName;

    @Column(name = "COMPANYADDRESS")
    private String companyAddress;

    @Column(name = "JOBTITLE")
    private String jobTitle;

    @Column(name = "CREDITINSNAME")
    private String creditInsname;

    @Column(name = "SALARY")
    private double salary;

    @Column(name = "MONTHS")
    private int months;

    @Column(name = "PRINCIPALPERMONTH")
    private double principalPerMonth;

    @Column(name = "INTERESTPERMONTH")
    private double interestPerMonth;

    @Column(name = "TOTALPERMONTH")
    private double totalperMonth;

    @Column(name = "INCOMETYPE")
    private String incomeType;
}
