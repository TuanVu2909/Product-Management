package com.technology.apigateway.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoanLimitRequest {
    private Integer id;
    private Integer custId;
    private Integer limitAmount;
    private Date createdDate;
}
