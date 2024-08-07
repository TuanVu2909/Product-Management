package com.technology.apigateway.database.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GUARDIANS")
@NamedQuery(name = "GuardiansEntity.findAll", query = "SELECT c FROM GuardiansEntity c")
public class GuardiansEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDATE")
    private String birthDate;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "MARITALSTATUS")
    private Integer maritalStatus;

    @Column(name = "IDNUMBER")
    private String idNumber;

    @Column(name = "IDDATE")
    private String idDate;

    @Column(name = "IDADDRESS")
    private String idAddress;

    @Column(name = "IDPLACE")
    private String idPlace;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATUSADDRESS")
    private String statusAddress;

    @Column(name = "CURRENTADDRESS")
    private String currentAddress;

    @Column(name = "ISFIELDWORK")
    private Integer isFieldWork;

    @Column(name = "RELATIONSHIP")
    private String relationship;

}