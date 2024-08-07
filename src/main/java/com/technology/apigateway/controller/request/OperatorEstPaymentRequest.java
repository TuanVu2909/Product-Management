package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperatorEstPaymentRequest {

    public String fullname;

    public String mobile;

    public String idnumber;

    public String branch;

    public Integer userId;

    public String documentNo;

    public String fromDate;

    public String toDate;

}
