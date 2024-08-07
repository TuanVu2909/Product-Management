package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AddressRequest {
    private String ward;
    private String district;
    private String province;
    private String residenceWard;
    private String residenceDistrict;
    private String residenceProvince;
    private String vehicleName;
    private Date lnDate;
}
