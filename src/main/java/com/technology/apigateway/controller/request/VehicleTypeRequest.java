package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class VehicleTypeRequest {

    private int id;

    private String name;

    private int type;
}
