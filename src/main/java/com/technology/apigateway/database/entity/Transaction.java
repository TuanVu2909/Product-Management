package com.technology.apigateway.database.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "TRANDATE")
    private Date tranDate;

    @Column(name = "TRANCODE")
    private String tranCode;

    @Column(name = "CUSTID")
    private int custId;

    @Column(name = "TRANVALUE")
    private int tranValue;

    @Column(name = "TRANDES")
    private String tranDes;

    @Column(name = "REF")
    private String ref;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATEDDATE")
    private Timestamp createdDate;

    @Column(name = "CREATEDUSER")
    private int createdUser;

    @Column(name = "APPROVEDUSER")
    private int approvedUser;

    @Column(name = "APPROVEDDATE")
    private Timestamp approvedDate;

    @Column(name = "TRANTYPE")
    private String tranType;
}
