package com.technology.apigateway.controller.request.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovePrePaymentRequest {
    private int loanId;
    private int approveUserId;

}
