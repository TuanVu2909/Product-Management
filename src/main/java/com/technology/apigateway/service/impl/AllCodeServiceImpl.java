package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.AllCodeRequest;
import com.technology.apigateway.database.entity.AllCode;
import com.technology.apigateway.database.repository.AllCodeRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.AllCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("allCodeService")
public class AllCodeServiceImpl implements AllCodeService {

    @Autowired
    private AllCodeRepository allCodeRepository;

    @Override
    public List<AllCodeRequest> getAllAllCode() {
        List<AllCode> allCodeList = allCodeRepository.getAllAllCode();
        if (allCodeList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found All code");
        }
        List<AllCodeRequest> allCodeRequestList = new ArrayList<>();
        for (AllCode allCode : allCodeList) {
            AllCodeRequest allCodeRequest = new AllCodeRequest();
            allCodeRequest.setId(allCode.getId());
            allCodeRequest.setCode(allCode.getCode());
            allCodeRequest.setType(allCode.getType());
            allCodeRequest.setName(allCode.getName());
            allCodeRequest.setLstOrder(allCode.getLstOrder());
            allCodeRequest.setState(allCode.getState());
            allCodeRequestList.add(allCodeRequest);
        }
        return allCodeRequestList;
    }

    @Override
    public List<AllCodeRequest> getAllCodeByType(String type) {
        List<AllCode> allCodeList = allCodeRepository.getAllCodeByType(type);
        if (allCodeList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Type");
        }
        List<AllCodeRequest> allCodeRequestList = new ArrayList<>();
        for (AllCode allCode : allCodeList) {
            AllCodeRequest allCodeRequest = new AllCodeRequest();
            allCodeRequest.setId(allCode.getId());
            allCodeRequest.setCode(allCode.getCode());
            allCodeRequest.setType(allCode.getType());
            allCodeRequest.setName(allCode.getName());
            allCodeRequest.setLstOrder(allCode.getLstOrder());
            allCodeRequest.setState(allCode.getState());
            allCodeRequestList.add(allCodeRequest);
        }
        return allCodeRequestList;
    }
}
