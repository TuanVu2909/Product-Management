package com.technology.apigateway.controller.request.references;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferenceRequest {
    private Integer userId;
    private String refName;
    private String mobile;
    private String relation;
    private String job;
    private Integer regId;

}
