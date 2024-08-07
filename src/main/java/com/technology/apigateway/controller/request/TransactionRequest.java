package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class TransactionRequest {

    private int id;

    private Date tranDate;

    private String tranCode;

    private int custId;

    private int tranValue;

    private String tranDes;

    private String ref;

    private String status;

    private Timestamp createdDate;

    private int createdUser;

    private int approvedUser;

    private Timestamp approvedDate;

    private String tranType;
}
