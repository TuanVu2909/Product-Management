package com.technology.apigateway.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupFunctionModel {
    private String groupId;

    private String groupName;

    private List<FunctionModel> lstFunctions;
}
