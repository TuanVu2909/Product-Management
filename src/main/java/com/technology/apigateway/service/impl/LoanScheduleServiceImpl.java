package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.LoanScheduleRequest;
import com.technology.apigateway.controller.request.OperatorLoanScheduleRequest;
import com.technology.apigateway.database.entity.LoanSchedule;
import com.technology.apigateway.database.entity.OperatorLoanSchedule;
import com.technology.apigateway.database.repository.LoanScheduleRepository;
import com.technology.apigateway.database.repository.OperatorLoanScheduleRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.LoanScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("loanScheduleService")
public class LoanScheduleServiceImpl implements LoanScheduleService {

    @Autowired
    private LoanScheduleRepository loanScheduleRepository;

    @Autowired
    private OperatorLoanScheduleRepository loanScheduleOperatorRepository;

    @Override
    public List<LoanScheduleRequest> getLoanScheduleByLoanId(int loanId) {
        List<LoanSchedule> loanScheduleList = loanScheduleRepository.getLoanScheduleByLoanId(loanId);
        if (loanScheduleList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Loan Schedule");
        }
        List<LoanScheduleRequest> loanScheduleRequestList = new ArrayList<>();
        for (LoanSchedule loanSchedule : loanScheduleList) {
            LoanScheduleRequest loanScheduleRequest = new LoanScheduleRequest();
            loanScheduleRequest.setId(loanSchedule.getId());
            loanScheduleRequest.setLoanId(loanSchedule.getLoanId());
            loanScheduleRequest.setDueNo(loanSchedule.getDueNo());
            loanScheduleRequest.setDuedate(loanSchedule.getDuedate());
            loanScheduleRequest.setPrinnml(loanSchedule.getPrinnml());
            loanScheduleRequest.setPrinovd(loanSchedule.getPrinovd());
            loanScheduleRequest.setIntnml(loanSchedule.getIntnml());
            loanScheduleRequest.setIntovd(loanSchedule.getIntovd());
            loanScheduleRequest.setPrinpaid(loanSchedule.getPrinpaid());
            loanScheduleRequest.setIntpaid(loanSchedule.getIntpaid());
            loanScheduleRequest.setAssetManagementFee(loanSchedule.getAssetManagementFee());
            loanScheduleRequest.setAssetManagementOvd(loanSchedule.getAssetManagementOvd());
            loanScheduleRequest.setAssetManagementPaid(loanSchedule.getAssetManagementPaid());
            loanScheduleRequest.setPaidDate(loanSchedule.getPaidDate());
            loanScheduleRequest.setEstPrin(loanSchedule.getEstPrin());
            loanScheduleRequest.setEstInt(loanSchedule.getEstInt());
            loanScheduleRequest.setCntDays(loanSchedule.getCntDays());
            loanScheduleRequest.setFeeOvd(loanSchedule.getFeeOvd());
            loanScheduleRequest.setFeeOvdPaid(loanSchedule.getFeeOvdPaid());
            loanScheduleRequest.setExpertiseFee(loanSchedule.getExpertiseFee());
            loanScheduleRequest.setExpertiseFeeOvd(loanSchedule.getExpertiseFeeOvd());
            loanScheduleRequest.setExpertiseFeePaid(loanSchedule.getExpertiseFeePaid());
            loanScheduleRequestList.add(loanScheduleRequest);
        }
        return loanScheduleRequestList;
    }

    @Override
    public List<OperatorLoanSchedule> operatorLoanSchedule(OperatorLoanScheduleRequest loanScheduleRequest) {
        List<OperatorLoanSchedule> operatorLoanSchedule = loanScheduleOperatorRepository.operatorLoanSchedule(
                loanScheduleRequest.getLoanId(),
                loanScheduleRequest.getLoanScheduleId(),
                loanScheduleRequest.getCustId(),
                loanScheduleRequest.getFullName(),
                loanScheduleRequest.getMobile(),
                loanScheduleRequest.getIdNumber(),
                loanScheduleRequest.getBranch(),
                loanScheduleRequest.getPayType(),
                loanScheduleRequest.getLoanStatus(),
                loanScheduleRequest.getLoanType(),
                loanScheduleRequest.getSaleFullName(),
                loanScheduleRequest.getLnFromDate(),
                loanScheduleRequest.getLnToDate());
        if (operatorLoanSchedule.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, ErrorCode.NOT_FOUND_OPERATOR_LOAN);
        }
        return operatorLoanSchedule;
    }
}
