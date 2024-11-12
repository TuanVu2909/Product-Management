package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.AdminUserRequest;
import com.technology.apigateway.controller.request.ProductsRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.AuthService;
import com.technology.apigateway.service.FilesStorageService;
import com.technology.apigateway.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
public class ProductsController extends BaseResponse<AuthService> {

    AuthService authenticationService;

    FilesStorageService filesStorageService;

    ProductsService productsService;

    @PostMapping("create-products")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createAdminUser(HttpServletRequest httpServletRequest,
                                             @RequestBody ProductsRequest request) {
        return response(toResult(productsService.createProducts(request)));
    }

    @PostMapping("update-products")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateAdminUser(HttpServletRequest httpServletRequest,
                                             @RequestBody ProductsRequest productRequest) {
        return response(toResult(productsService.updateProducts(productRequest)));
    }
}
