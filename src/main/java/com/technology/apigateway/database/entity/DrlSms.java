package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "drlsms")
public class DrlSms {
    @Id
    @Column(name = "smsid")
    private String smsid;

    @Column(name = "receivedts")
    private Long receivedts;

    @Column(name = "deliveredts")
    private Long deliveredts;

    @Column(name = "status")
    private int status;

    @Column(name = "userapi")
    private String user;

    @Column(name = "fromsms")
    private String from;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "text")
    private String text;

    @Column(name = "errorcode")
    private int errorcode;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "mnp")
    private int mnp;

}

