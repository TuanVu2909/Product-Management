package com.technology.apigateway.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllCodeModel {
    private int id;

    private String code;

    private List<TypeModel> lstType;

    private String name;

    private int lstOrder;

    private int state;
}
