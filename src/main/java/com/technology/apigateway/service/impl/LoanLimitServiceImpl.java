package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.LoanLimitRequest;
import com.technology.apigateway.database.entity.ListLoanLimit;
import com.technology.apigateway.database.entity.status.LoanLimitStatus;
import com.technology.apigateway.database.repository.LoanLimitRepository;
import com.technology.apigateway.database.repository.LoanLimitStatusRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.LoanLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loanLimitService")
public class LoanLimitServiceImpl implements LoanLimitService {

    @Autowired
    LoanLimitStatusRepository loanLimitStatusRepository;

    @Autowired
    LoanLimitRepository loanLimitRepository;

    @Override
    public LoanLimitStatus createLoanLimit(LoanLimitRequest loanLimitRequest) {
        LoanLimitStatus loanLimitStatus;
        try {
            loanLimitStatus = loanLimitStatusRepository.createLoanLimit(
                    loanLimitRequest.getCustId(),
                    loanLimitRequest.getLimitAmount());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanLimitStatus;
    }

    @Override
    public List<ListLoanLimit> getListLoanLimit(LoanLimitRequest loanLimitRequest) {
        List<ListLoanLimit> loanLimitList = loanLimitRepository.getListLoanLimit(loanLimitRequest.getCustId());
        if (loanLimitList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Loan Limit");
        }
        return loanLimitList;
    }
}
