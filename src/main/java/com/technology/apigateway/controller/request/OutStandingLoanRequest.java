package com.technology.apigateway.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OutStandingLoanRequest {

    Integer userId;

    String fullName;

    String branch;

    String fromDate;

    String toDate;
}
