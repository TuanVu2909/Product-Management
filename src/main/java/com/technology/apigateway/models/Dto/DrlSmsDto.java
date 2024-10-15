package com.technology.apigateway.models.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrlSmsDto {
    private String smsid;
    private Long receivedts;
    private Long deliveredts;
    private Integer status;
    private String user;
    private String from;
    private String mobile;
    private String text;
    private Integer errorcode;
    private String carrier;
    private Integer mnp;
}
