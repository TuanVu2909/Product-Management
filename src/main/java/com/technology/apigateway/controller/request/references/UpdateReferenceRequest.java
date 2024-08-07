package com.technology.apigateway.controller.request.references;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReferenceRequest {
    private int id;
    private int userId;
    private String refName;
    private String relation;
    private String mobile;
    private String job;
}
