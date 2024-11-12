package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.CustomerRequest;
import com.technology.apigateway.controller.request.ProductsRequest;
import com.technology.apigateway.database.entity.*;
import com.technology.apigateway.database.entity.status.CustomerStatus;

import java.io.IOException;
import java.util.List;

public interface CustomerService {


    List<UserFile> getUserFile(Integer custId) throws IOException;

    List<UserFile> getUserFileByRegId(Integer regId) throws IOException;

    Products createCustomers(CustomerRequest request);

    Products updateCustomers(CustomerRequest productRequest);


}
