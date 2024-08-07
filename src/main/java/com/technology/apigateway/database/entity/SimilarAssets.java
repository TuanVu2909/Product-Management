package com.technology.apigateway.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "SIMILARASSETS")
@NamedQuery(name = "SimilarAssets.findAll", query = "SELECT c FROM SimilarAssets c")
public class SimilarAssets {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "USERID")
    private int userId;
    @Column(name = "VALUE")
    private double value;
    @Column(name = "LINKWEBSITE")
    private String linkWebsite;
}
