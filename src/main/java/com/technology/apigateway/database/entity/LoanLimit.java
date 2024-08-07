package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "LOANLIMIT")
public class LoanLimit {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CUSTID")
    private int custId;

    @Column(name = "LIMITAMOUNT")
    private int limitAmount;

    @Column(name = "CREATEDDATE")
    private Date createdDate;

}
