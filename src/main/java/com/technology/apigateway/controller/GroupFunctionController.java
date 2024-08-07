package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.GroupFunctionRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.runner.DataLoader;
import com.technology.apigateway.service.GroupFunctionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class GroupFunctionController extends BaseResponse {

    @Autowired
    GroupFunctionService groupFunctionService;

    @PostMapping("create-group-function")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createGroupFunction(HttpServletRequest httpServletRequest,
            @RequestBody GroupFunctionRequest groupFunctionRequest) {
        return response(toResult(groupFunctionService.createGroupFunction(groupFunctionRequest)));
    }

    @GetMapping("get-all-group-function")
    // @Transactional(readOnly = true)
    public ResponseEntity<?> getAllGroupFunction(HttpServletRequest httpServletRequest) {
        return response(toResult(DataLoader.groupFunction));
    }

}
