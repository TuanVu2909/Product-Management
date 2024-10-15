package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer status;

    @Column(name = "userapi")
    private String user;

    @Column(name = "fromsms")
    private String from;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "text")
    private String text;

    @Column(name = "errorcode")
    private Integer errorcode;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "mnp")
    private Integer mnp;

}

