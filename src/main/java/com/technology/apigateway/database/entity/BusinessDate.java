package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BUSINESSDATE")
public class BusinessDate {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DATETYPE")
    private String dateType;

    @Column(name = "DATEVAL")
    private String dateVal;
}
