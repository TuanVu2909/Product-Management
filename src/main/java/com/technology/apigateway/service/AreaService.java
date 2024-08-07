package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.AreaRequest;
import com.technology.apigateway.models.AreaModel;

import java.util.List;

public interface AreaService {

    List<AreaRequest> getAllArea();
}
