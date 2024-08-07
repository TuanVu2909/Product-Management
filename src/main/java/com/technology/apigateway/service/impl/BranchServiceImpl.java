package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.BranchRequest;
import com.technology.apigateway.database.entity.Branch;
import com.technology.apigateway.database.repository.AreaRepository;
import com.technology.apigateway.database.repository.BranchRepository;
import com.technology.apigateway.database.repository.RegionRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("branchService")
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<BranchRequest> getAllBranch() {
        List<Branch> branchList = branchRepository.getAllBranch();
        if (branchList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Branch");
        }
        List<BranchRequest> branchRequestList = new ArrayList<>();
        for (Branch branch : branchList) {
            BranchRequest branchRequest = new BranchRequest();
            branchRequest.setBid(branch.getBid());
            branchRequest.setName(branch.getName());
            branchRequest.setAid(branch.getAid());
            branchRequest.setStatus(branch.getStatus());
            branchRequest.setRid(branch.getRid());
            branchRequest.setFullAddress(branch.getFullAddress());
            branchRequestList.add(branchRequest);
        }
        return branchRequestList;
    }
}
