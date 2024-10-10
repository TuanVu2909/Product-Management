package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.LoanDetailRequest;
import com.technology.apigateway.controller.response.LoanDetailResponse;

import java.util.List;

public interface LoanDetailService {

    List<LoanDetailResponse> getLoanById(LoanDetailRequest request);
}
