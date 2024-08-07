package com.technology.apigateway.controller;

import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.AreaService;
import com.technology.apigateway.service.RegionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "https://apigateway.lendbiz.vn", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Log4j2
public class AreaController extends BaseResponse {
    @Autowired
    AreaService areaService;

    @Autowired
    RegionService regionService;

    @GetMapping("get-all-area")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllArea(HttpServletRequest httpServletRequest) {
        return response(toResult(areaService.getAllArea()));
    }

    @GetMapping("get-all-region")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllRegion(HttpServletRequest httpServletRequest) {
        return response(toResult(regionService.getAllRegion()));
    }

}
