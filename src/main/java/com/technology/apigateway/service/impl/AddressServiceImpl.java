package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.DistrictRequest;
import com.technology.apigateway.controller.request.ProvinceRequest;
import com.technology.apigateway.controller.request.WardRequest;
import com.technology.apigateway.database.entity.District;
import com.technology.apigateway.database.entity.Province;
import com.technology.apigateway.database.entity.Ward;
import com.technology.apigateway.database.repository.DistrictRepository;
import com.technology.apigateway.database.repository.ProvinceRepository;
import com.technology.apigateway.database.repository.WardRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private WardRepository wardRepository;

    @Override
    public List<DistrictRequest> getAllDistrict() {
        List<District> districtList = districtRepository.getAllDistrict();
        if (districtList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found District");
        }
        List<DistrictRequest> districtRequestList = new ArrayList<>();
        for (District district : districtList) {
            DistrictRequest districtRequest = new DistrictRequest();
            districtRequest.setId(district.getId());
            districtRequest.setDName(district.getDName());
            districtRequest.setEnName(district.getEnName());
            districtRequest.setDLevel(district.getDLevel());
            districtRequest.setPid(district.getPid());
            districtRequestList.add(districtRequest);
        }
        return districtRequestList;
    }

    @Override
    public List<DistrictRequest> getDistrictByPid(int pid) {
        List<District> districtList = districtRepository.getDistrictsByPid(pid);
        if (districtList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found District");
        }
        List<DistrictRequest> districtRequestList = new ArrayList<>();
        for (District district : districtList) {
            DistrictRequest districtRequest = new DistrictRequest();
            districtRequest.setId(district.getId());
            districtRequest.setDName(district.getDName());
            districtRequest.setEnName(district.getEnName());
            districtRequest.setDLevel(district.getDLevel());
            districtRequest.setPid(district.getPid());
            districtRequestList.add(districtRequest);
        }
        return districtRequestList;
    }

    @Override
    public List<ProvinceRequest> getAllProvince() {
        List<Province> provinceList = provinceRepository.getAllProvince();
        if (provinceList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Province");
        }
        List<ProvinceRequest> provinceRequestList = new ArrayList<>();
        for (Province province : provinceList) {
            ProvinceRequest provinceRequest = new ProvinceRequest();
            provinceRequest.setId(province.getId());
            provinceRequest.setPName(province.getPName());
            provinceRequest.setEnName(province.getEnName());
            provinceRequest.setPLevel(province.getPLevel());
            provinceRequest.setShortName(province.getShortName());
            provinceRequestList.add(provinceRequest);
        }
        return provinceRequestList;
    }

    @Override
    public List<WardRequest> getWardByDid(int did) {
        List<Ward> wardList = wardRepository.getWardByDid(did);
        if (wardList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Ward");
        }
        List<WardRequest> wardRequestList = new ArrayList<>();
        for (Ward ward : wardList) {
            WardRequest wardRequest = new WardRequest();
            wardRequest.setId(ward.getId());
            wardRequest.setWName(ward.getWName());
            wardRequest.setEnName(ward.getEnName());
            wardRequest.setWLevel(ward.getWLevel());
            wardRequest.setDid(ward.getDid());
            wardRequestList.add(wardRequest);
        }
        return wardRequestList;
    }

    @Override
    public List<WardRequest> getAllWard() {
        List<Ward> wardList = wardRepository.getAllWard();
        if (wardList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Ward");
        }
        List<WardRequest> wardRequestList = new ArrayList<>();
        for (Ward ward : wardList) {
            WardRequest wardRequest = new WardRequest();
            wardRequest.setId(ward.getId());
            wardRequest.setWName(ward.getWName());
            wardRequest.setEnName(ward.getEnName());
            wardRequest.setWLevel(ward.getWLevel());
            wardRequest.setDid(ward.getDid());
            wardRequestList.add(wardRequest);
        }
        return wardRequestList;
    }
}
