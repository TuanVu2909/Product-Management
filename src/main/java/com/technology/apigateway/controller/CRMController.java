package com.technology.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technology.apigateway.controller.request.LoginRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.controller.response.LoginResponse;
import com.technology.apigateway.database.repository.AdminUserRepository;
import com.technology.apigateway.security.CustomUserDetails;
import com.technology.apigateway.security.JwtTokenProvider;
import com.technology.apigateway.service.AuthService;

import lombok.extern.log4j.Log4j2;

// //@CrossOrigin(origins = "https://apigateway.lendbiz.vn", maxAge = 3600)
@RestController
@RequestMapping("/authentication")
@Log4j2
public class CRMController extends BaseResponse<AuthService> {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AdminUserRepository userRepository;

    @PostMapping("token")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        LoginResponse jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());

        System.out.println("test jenkins!11");

        return response(toResult(jwt));
    }

}
