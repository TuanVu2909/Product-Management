package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.BranchRequest;

import java.util.List;

public interface BranchService {

    List<BranchRequest> getAllBranch();
}
