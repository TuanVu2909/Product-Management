package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperatorTransactionRequest {
    public String fullName;

    public String mobile;

    public String idNumber;

    public String branch;

    public String tranName;

    public String tranDes;

    public String fromDate;

    public String toDate;

}
