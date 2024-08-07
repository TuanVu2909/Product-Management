package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.RegionRequest;

import java.util.List;

public interface RegionService {
    List<RegionRequest> getAllRegion();
}
