package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.MainRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.AuthService;
import com.technology.apigateway.service.MainService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MainController extends BaseResponse<AuthService> {

    MainService mainService;

    @PostMapping("register")
    @Transactional(readOnly = true)
    public ResponseEntity<?> login(@RequestBody MainRequest mainRequest) {
        return response(toResult(mainService.register(mainRequest)));
    }
}
