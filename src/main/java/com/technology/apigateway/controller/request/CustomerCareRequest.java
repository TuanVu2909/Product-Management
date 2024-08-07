package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class CustomerCareRequest {
    private int id;
    private int custId;
    private String careId;
    private String careType;
    private Date createdDate;
}
