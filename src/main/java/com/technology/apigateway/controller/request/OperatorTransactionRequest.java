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
public class OperatorTransactionRequest {
    String fullName;

    String mobile;

    String idNumber;

    String branch;

    String tranName;

    String tranDes;

    String fromDate;

    String toDate;

    Integer userId;
}
