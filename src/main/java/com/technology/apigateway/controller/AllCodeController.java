package com.technology.apigateway.controller;

import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.AllCodeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AllCodeController extends BaseResponse {

    AllCodeService allCodeService;

    @GetMapping("get-all-allCode")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllAllCode(HttpServletRequest httpServletRequest) {
        return response(toResult(allCodeService.getAllAllCode()));
    }

    @GetMapping("get-all-code-by-type/{type}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllCodeByType(HttpServletRequest httpServletRequest, @PathVariable String type) {
        return response(toResult(allCodeService.getAllCodeByType(type)));
    }
}
