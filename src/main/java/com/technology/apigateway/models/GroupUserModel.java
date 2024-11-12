package com.technology.apigateway.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupUserModel {
    private String gid;

    private String name;

    private List<RegionModel> lstRegions;

    private List<AreaModel> lstAreas;

    private List<Branch> lstBranchs;
}
