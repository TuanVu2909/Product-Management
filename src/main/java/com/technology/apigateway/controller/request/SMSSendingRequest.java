package com.technology.apigateway.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SMSSendingRequest {

    @NotBlank
    private String from;

    @NotNull
    private String to;

    @NotBlank
    private String text;

    private String unicode;

    private Integer dlr = 0;

    private String smsId;

    private String campaignId;

}
