package com.technology.apigateway.runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.technology.apigateway.database.entity.AllCode;
import com.technology.apigateway.database.entity.PayTypeConfig;
import com.technology.apigateway.database.entity.RateAndFee;
import com.technology.apigateway.database.repository.AllCodeRepository;
import com.technology.apigateway.database.repository.PayTypeRepository;
import com.technology.apigateway.database.repository.RateAndFeeRepository;
import com.technology.apigateway.models.GroupFunctionModel;
import com.technology.apigateway.service.BranchService;
import com.technology.apigateway.service.GroupFunctionService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class DataLoader implements ApplicationRunner {

    @Autowired
    GroupFunctionService groupFunctionService;

    @Autowired
    BranchService branchService;

    @Autowired
    AllCodeRepository allCodeRepository;

    @Autowired
    PayTypeRepository payTypeRepository;

    @Autowired
    RateAndFeeRepository feeRepository;

    public static Map<String, AllCode> mapAllCode = new HashMap<>();

    public static Map<String, PayTypeConfig> mapAllPayType = new HashMap<>();

    public static Map<String, RateAndFee> mapRateAndFee = new HashMap<>();

    public static List<GroupFunctionModel> groupFunction;

    @Transactional(readOnly = true)
    public void run(ApplicationArguments args) {
        groupFunction = groupFunctionService.getGroupFunction();

        loadStaticData();
    }

    private void loadStaticData() {

        log.info("Start LoadStaticData: ");
        for (AllCode allCode : allCodeRepository.getAllAllCode()) {
            mapAllCode.put(allCode.getCode() + allCode.getType(), allCode);
        }

        for (PayTypeConfig payTypeConfig : payTypeRepository.findAll()) {
            mapAllPayType.put(payTypeConfig.getLoanType(), payTypeConfig);
        }

        for (RateAndFee rateAndFee : feeRepository.findAll()) {
            mapRateAndFee.put(rateAndFee.getLoanType() + rateAndFee.getRafType(), rateAndFee);
        }

    }
}