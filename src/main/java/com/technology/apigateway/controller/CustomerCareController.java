package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.CustomerCareRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.CustomerCareService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "https://apigateway.lendbiz.vn", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerCareController extends BaseResponse {

    CustomerCareService customerCareService;

    @GetMapping("get-all-customer-care")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllCustomerCare(HttpServletRequest httpServletRequest) {
        return response(toResult(customerCareService.getAllCustomerCare()));
    }

    @PostMapping("create-customer-care")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createCustomerCare(HttpServletRequest httpServletRequest,
                                                @RequestBody CustomerCareRequest customerCareRequest) {
        return response(toResult(customerCareService.createCustomerCare(customerCareRequest)));
    }

    @PostMapping("update-customer-care")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateCustomerCare(HttpServletRequest httpServletRequest,
                                                @RequestBody CustomerCareRequest customerCareRequest) {
        return response(toResult(customerCareService.updateCustomerCare(customerCareRequest)));
    }
}
