package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.AdminUserRequest;
import com.technology.apigateway.controller.request.ProductsRequest;
import com.technology.apigateway.database.entity.AdminUser;
import com.technology.apigateway.database.entity.Products;

public interface ProductsService {

    Products createProducts(ProductsRequest request);

    Products updateProducts(ProductsRequest productRequest);
}
