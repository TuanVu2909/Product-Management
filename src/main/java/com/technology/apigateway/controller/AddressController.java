package com.technology.apigateway.controller;

import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.AddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "https://apigateway.lendbiz.vn", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Log4j2
public class AddressController extends BaseResponse {

    @Autowired
    AddressService addressService;

    @GetMapping("get-all-district")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllDistrict(HttpServletRequest httpServletRequest) {
        return response(toResult(addressService.getAllDistrict()));
    }

    @GetMapping("get-district-by-pid/{pid}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getDistrictByIdPid(HttpServletRequest httpServletRequest, @PathVariable int pid) {
        return response(toResult(addressService.getDistrictByPid(pid)));
    }

    @GetMapping("get-all-province")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllProvince(HttpServletRequest httpServletRequest) {
        return response(toResult(addressService.getAllProvince()));
    }

    @GetMapping("get-all-ward")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllWard(HttpServletRequest httpServletRequest) {
        return response(toResult(addressService.getAllWard()));
    }

    @GetMapping("get-ward-by-did/{did}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllWard(HttpServletRequest httpServletRequest, @PathVariable int did) {
        return response(toResult(addressService.getWardByDid(did)));
    }


}
