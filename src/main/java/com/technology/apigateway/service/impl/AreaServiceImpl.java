package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.AreaRequest;
import com.technology.apigateway.database.entity.Area;
import com.technology.apigateway.database.repository.AreaRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<AreaRequest> getAllArea() {
        List<Area> areaList = areaRepository.getAllArea();
        if (areaList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Area");
        }
        List<AreaRequest> areaRequestList = new ArrayList<>();
        for (Area area : areaList) {
            AreaRequest areaRequest = new AreaRequest();
            areaRequest.setAid(area.getAid());
            areaRequest.setName(area.getName());
            areaRequest.setRid(area.getRid());
            areaRequest.setDescription(area.getDescription());
            areaRequestList.add(areaRequest);
        }
        return areaRequestList;
    }
}