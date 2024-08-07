package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.RegionRequest;
import com.technology.apigateway.database.entity.Region;
import com.technology.apigateway.database.repository.RegionRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("regionService")
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<RegionRequest> getAllRegion() {
        List<Region> regionList = regionRepository.getAllRegion();
        if (regionList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Region");
        }
        List<RegionRequest> regionRequestList = new ArrayList<>();
        for (Region region : regionList) {
            RegionRequest regionRequest = new RegionRequest();
            regionRequest.setRid(region.getRid());
            regionRequest.setName(region.getName());
            regionRequest.setDescription(region.getDescription());
            regionRequest.setStatus(region.getStatus());
            regionRequestList.add(regionRequest);
        }
        return regionRequestList;
    }
}
