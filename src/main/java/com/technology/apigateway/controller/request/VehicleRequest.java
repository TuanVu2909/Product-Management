package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class VehicleRequest {
    private int id;

    private String name;

    private int companyId;
}
