package com.technology.apigateway.controller;

import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.BusinessDateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessDateController extends BaseResponse {

    BusinessDateService businessDateService;

    /*
    * Hiển thị ngày batch hiện tại trong hệ thống
    * */
    @PostMapping("get-business-date")
    public ResponseEntity<?> getBusinessDate(HttpServletRequest httpServletRequest) {
        return response(toResult(businessDateService.getBusinessDates()));
    }
}
