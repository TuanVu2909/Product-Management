package com.technology.apigateway.service.impl;

import com.technology.apigateway.controller.request.MainRequest;
import com.technology.apigateway.controller.request.SimilarAssetsRequest;
import com.technology.apigateway.controller.request.incomes.IncomesMonthRequest;
import com.technology.apigateway.controller.request.incomes.IncomesRequest;
import com.technology.apigateway.database.entity.status.CustomerCareStatus;
import com.technology.apigateway.database.entity.status.CustomerStatus;
import com.technology.apigateway.database.repository.CustomerCareStatusRepository;
import com.technology.apigateway.database.repository.CustomerStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service("mainServiceImpl")
public class MainServiceImpl implements MainService {

    @Autowired
    CustomerStatusRepository customerStatusRepository;

    @Autowired
    CustomerCareStatusRepository customerCareStatusRepository;

    @Override
    public String register(MainRequest mainRequest) {

        CustomerStatus customerStatus = customerStatusRepository.createCustomer(
                mainRequest.getFullName(),
                mainRequest.getMobile(),
                mainRequest.getDob(),
                mainRequest.getIdType(),
                mainRequest.getIdNumber(),
                mainRequest.getIdDate(),
                mainRequest.getIdPlace(),
                mainRequest.getIdExpired(),
                mainRequest.getAddress(),
                mainRequest.getWardId(),
                mainRequest.getDistrictId(),
                mainRequest.getProvinceId(),
                mainRequest.getEmail(),
                mainRequest.getMarried(),
                mainRequest.getProfession(),
                mainRequest.getEducation(),
                mainRequest.getCustType(),
                mainRequest.getStatus(),
                mainRequest.getCreatedDate(),
                mainRequest.getIncome(),
                mainRequest.getResidency(),
                mainRequest.getResidencyTime(),
                mainRequest.getDependentPerson(),
                mainRequest.getWorkingPeriod(),
                mainRequest.getResidenceAddress(),
                mainRequest.getResidenceWardId(),
                mainRequest.getResidenceDistrictId(),
                mainRequest.getResidenceProvinceId(),
                mainRequest.getBankName(),
                mainRequest.getBankAccountNumber(),
                mainRequest.getGender(),
                mainRequest.getRelationshipWithFiny(),
                mainRequest.getWorkAddress(),
                mainRequest.getNameCompany(),
                mainRequest.getEthics(),
                mainRequest.getGuardName(),
                mainRequest.getGuardBirth(),
                mainRequest.getGuardMobile(),
                mainRequest.getGuardMaritalStatus(),
                mainRequest.getGuardIdNumber(),
                mainRequest.getGuardIdDate(),
                mainRequest.getGuardIdAddress(),
                mainRequest.getGuardIdPlace(),
                mainRequest.getGuardAddress(),
                mainRequest.getGuardStatusAddress(),
                mainRequest.getGuardCurrentAddress(),
                mainRequest.getGuardIsFieldWork(),
                mainRequest.getGuardRelationship(),
                mainRequest.getVehUseFor(),
                mainRequest.getVehCrack(),
                mainRequest.getVehScratch(),
                mainRequest.getVehOthersState(),
                mainRequest.getDescriptionWork());

        if (customerStatus.getStatus().equals("00")) {
            throw new BusinessException("01", customerStatus.getDescription());
        }

        if (mainRequest.getIncomes() != null) {
            for (IncomesRequest incomesRequest : mainRequest.getIncomes()) {
                customerStatusRepository.createIncomes(Integer.parseInt(customerStatus.getDescription()), "", "", "",
                        incomesRequest.getIncomePerMonth(), incomesRequest.getCreditInsName(),
                        incomesRequest.getMonth(), incomesRequest.getPrincipalPerMonth(),
                        incomesRequest.getInterestPerMonth(), incomesRequest.getTotalPerMonth(), incomesRequest.getIncomeType());
            }
        }

        if (mainRequest.getIncomeMonth() != null) {
            for (IncomesMonthRequest incomesMonthRequest : mainRequest.getIncomeMonth()) {
                customerStatusRepository.createIncomes(Integer.parseInt(customerStatus.getDescription()), "", "", "",
                        incomesMonthRequest.getIncomeMonth(), incomesMonthRequest.getCreditInsName(),
                        incomesMonthRequest.getMonth(), incomesMonthRequest.getPrincipalPerMonth(),
                        incomesMonthRequest.getInterestPerMonth(), incomesMonthRequest.getTotalPerMonth(), incomesMonthRequest.getIncomeType());
            }
        }

        if (mainRequest.getSimilarAssets() != null) {
            for (SimilarAssetsRequest similarAssetsRequest : mainRequest.getSimilarAssets()) {
                customerStatusRepository.createSimilarAssets(Integer.parseInt(customerStatus.getDescription()),
                        similarAssetsRequest.getValue(),
                        similarAssetsRequest.getLinkWebsite());
            }
        }

        String custId = customerStatus.getDescription(); // create customer trả về custid
        log.info("MA KHACH HANG: " + custId);
        CustomerCareStatus customerCareStatus = customerCareStatusRepository.createCustomerCare(
                Integer.parseInt(custId),
                mainRequest.getCareId(),
                mainRequest.getCareType());
        if (customerCareStatus.getStatus().equals("00")) {
            throw new BusinessException("01", customerCareStatus.getDescription());
        }

        int proffession = 1;
        int age = 1;
        int residency = 1;
        int residencyTime = 1;
        int maritalstatus = 1;
        int depedency = 1;
        int relwithfiny = 1;
        int incomeprovetype = 1;
        int income = 1;
        int workingtime = 1;
        int insurance = 1;
        int assettype = 1;
        int assetvalue = 1;
        int assetusefor = 1;

        customerStatusRepository.createScoring(Integer.valueOf(custId), proffession,
                age,
                residency,
                residencyTime,
                maritalstatus,
                depedency,
                relwithfiny,
                incomeprovetype,
                income,
                workingtime,
                insurance,
                assettype,
                assetvalue,
                assetusefor);

        customerStatusRepository.calScoring(Integer.valueOf(custId));

        return customerStatus.getDescription();
    }
}
