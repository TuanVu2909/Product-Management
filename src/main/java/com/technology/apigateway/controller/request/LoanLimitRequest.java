package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class LoanLimitRequest {
    private Integer id;
    private Integer custId;
    private Integer limitAmount;
    private Date createdDate;
}
