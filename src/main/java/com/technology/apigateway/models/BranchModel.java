package com.technology.apigateway.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BranchModel {
    private String bid;
    private String name;
    private List<AreaModel> lstAreas;
    private int status;
    private List<RegionModel> lstRegions;
    private String fullAddress;

}
