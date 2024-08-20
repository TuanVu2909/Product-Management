package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.LoanRegistrationRequest;
import com.technology.apigateway.database.entity.ListLoanRegistration;
import com.technology.apigateway.database.entity.LoanRegistrationStatus;
import com.technology.apigateway.database.repository.LoanRegistrationRepository;
import com.technology.apigateway.database.repository.LoanRegistrationStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.LoanRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loanRegistrationService")
public class LoanRegistrationServiceImpl implements LoanRegistrationService {

    @Autowired
    LoanRegistrationRepository loanRegistrationRepository;

    @Autowired
    LoanRegistrationStatusRepository loanRegistrationStatusRepository;

    @Override
    public List<ListLoanRegistration> getLoanRegistration(LoanRegistrationRequest loanRegistrationRequest) {
        List<ListLoanRegistration> loanRegistrationList = loanRegistrationRepository
                .getLoanRegistration(loanRegistrationRequest.getId());
        if (loanRegistrationList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Loan Registration");
        }
        return loanRegistrationList;
    }

    @Override
    public LoanRegistrationStatus createLoanRegistration(LoanRegistrationRequest loanRegistrationRequest) {
        LoanRegistrationStatus loanRegistrationStatus;
        try {
            loanRegistrationStatus = loanRegistrationStatusRepository.createLoanRegistration(
                    loanRegistrationRequest.getCustId(),
                    loanRegistrationRequest.getVehicleType(),
                    loanRegistrationRequest.getVehicleId(),
                    loanRegistrationRequest.getVehicleNumber(),
                    loanRegistrationRequest.getRegistrationNumber(),
                    loanRegistrationRequest.getEngineNumber(),
                    loanRegistrationRequest.getChassisNumber(),
                    loanRegistrationRequest.getVehiclePrice(),
                    loanRegistrationRequest.getLoanAmount(),
                    loanRegistrationRequest.getTerm(),
                    loanRegistrationRequest.getSaleId(),
                    loanRegistrationRequest.getSaleNote(),
                    loanRegistrationRequest.getIncomeProveType(),
                    loanRegistrationRequest.getTermType(),
                    loanRegistrationRequest.getVehicleOwnerName(),
                    loanRegistrationRequest.getVehicleColor(),
                    loanRegistrationRequest.getAddressVehicleDocuments(),
                    loanRegistrationRequest.getLoanType(),
                    loanRegistrationRequest.getVehicleOrigin(),
                    loanRegistrationRequest.getVehicleRegistrationIssued(),
                    loanRegistrationRequest.getVehicleRegistrationDate(),
                    loanRegistrationRequest.getPurposeUsingLoan(),
                    loanRegistrationRequest.getVehicleBrand(),
                    loanRegistrationRequest.getPayType(),
                    loanRegistrationRequest.getFuel(),
                    loanRegistrationRequest.getNumberPeopleAllow());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanRegistrationStatus;
    }

    @Override
    public LoanRegistrationStatus updateLoanRegistration(LoanRegistrationRequest loanRegistrationRequest) {
        LoanRegistrationStatus loanRegistrationStatus;
        try {
            loanRegistrationStatus = loanRegistrationStatusRepository.updateLoanRegistration(
                    loanRegistrationRequest.getId(),
                    loanRegistrationRequest.getCustId(),
                    loanRegistrationRequest.getVehicleType(),
                    loanRegistrationRequest.getVehicleId(),
                    loanRegistrationRequest.getVehicleNumber(),
                    loanRegistrationRequest.getRegistrationNumber(),
                    loanRegistrationRequest.getEngineNumber(),
                    loanRegistrationRequest.getChassisNumber(),
                    loanRegistrationRequest.getVehiclePrice(),
                    loanRegistrationRequest.getLoanAmount(),
                    loanRegistrationRequest.getTerm(),
                    loanRegistrationRequest.getStatus(),
                    loanRegistrationRequest.getSaleId(),
                    loanRegistrationRequest.getCoId(),
                    loanRegistrationRequest.getSaleNote(),
                    loanRegistrationRequest.getCoNote(),
                    loanRegistrationRequest.getIncomeProveType(),
                    loanRegistrationRequest.getTermType(),
                    loanRegistrationRequest.getVehicleOwnerName(),
                    loanRegistrationRequest.getVehicleColor(),
                    loanRegistrationRequest.getAddressVehicleDocuments(),
                    loanRegistrationRequest.getLoanType(),
                    loanRegistrationRequest.getVehicleOrigin(),
                    loanRegistrationRequest.getVehicleRegistrationIssued(),
                    loanRegistrationRequest.getVehicleRegistrationDate(),
                    loanRegistrationRequest.getPurposeUsingLoan(),
                    loanRegistrationRequest.getVehicleBrand(),
                    loanRegistrationRequest.getPayType(),
                    loanRegistrationRequest.getFuel(),
                    loanRegistrationRequest.getNumberPeopleAllow());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanRegistrationStatus;
    }

    @Override
    public List<ListLoanRegistration> getListLoanRegistration(LoanRegistrationRequest request) {
        List<ListLoanRegistration> loanRegistrationList = loanRegistrationRepository.getListLoanRegistration(
                request.getId(),
                request.getCustId(),
                request.getVehicleType(),
                request.getVehicleNumber(),
                request.getRegistrationNumber(),
                request.getEngineNumber(),
                request.getChassisNumber(),
                request.getTerm(),
                request.getStatus(),
                request.getSaleId(),
                request.getCoId(),
                request.getRegFromDate(),
                request.getRegToDate(),
                request.getTermType(),
                request.getVehicleOwnerName(),
                request.getVehicleColor(),
                request.getAddressVehicleDocuments(),
                request.getLoanType(),
                request.getVehicleOrigin(),
                request.getVehicleRegistrationIssued(),
                request.getVehicleRegistrationDate(),
                request.getPurposeUsingLoan(),
                request.getVehicleBrand(),
                request.getPayType());
        if (loanRegistrationList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found List Loan Registration");
        }
        return loanRegistrationList;
    }

    @Override
    public LoanRegistrationStatus updateLoanRegistrationStatus(LoanRegistrationRequest loanRegistrationRequest) {
        LoanRegistrationStatus loanRegistrationStatus;
        try {
            loanRegistrationStatus = loanRegistrationStatusRepository.updateLoanRegistrationStatus(
                    loanRegistrationRequest.getId(),
                    loanRegistrationRequest.getStatus(),
                    loanRegistrationRequest.getFinyPay());

            if (!loanRegistrationStatus.getStatus().equals("01")) {
                throw new BusinessException(ErrorCode.UNKNOWN_ERROR, loanRegistrationStatus.getDescription());
            }

        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanRegistrationStatus;
    }
}
