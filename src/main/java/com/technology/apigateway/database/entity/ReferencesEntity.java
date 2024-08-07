package com.technology.apigateway.database.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "REFERENCES")
@NamedQuery(name = "ReferencesEntity.findAll", query = "SELECT c FROM ReferencesEntity c")
public class ReferencesEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "REFNAME")
    private String refName;

    @Column(name = "REFMOBILE")
    private String refMobile;

    @Column(name = "REFRELATION")
    private String refRelation;

    @Column(name = "REFJOB")
    private String refJob;

    @Column(name = "REGID")
    private Integer regId;

    @Column(name = "CREATEDDATE")
    private Date createDate;

}