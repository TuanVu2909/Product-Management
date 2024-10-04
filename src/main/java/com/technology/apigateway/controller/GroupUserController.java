package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.GroupUserRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.GroupUserService;
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

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupUserController extends BaseResponse {

    GroupUserService groupUserService;

    @GetMapping("get-all-group-user")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllGroupUser(HttpServletRequest httpServletRequest) {
        return response(toResult(groupUserService.getAllGroupUser()));
    }

    @PostMapping("create-group-user")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createGroupUser(HttpServletRequest httpServletRequest,
            @RequestBody GroupUserRequest request) {
        return response(toResult(groupUserService.createGroupUser(request)));
    }
}
