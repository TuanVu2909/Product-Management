package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.DistrictRequest;
import com.technology.apigateway.controller.request.ProvinceRequest;
import com.technology.apigateway.controller.request.WardRequest;

import java.util.List;

public interface AddressService {

    List<DistrictRequest> getAllDistrict();

    List<DistrictRequest> getDistrictByPid(int pid);

    List<ProvinceRequest> getAllProvince();

    List<WardRequest> getAllWard();

    List<WardRequest> getWardByDid(int did);
}
