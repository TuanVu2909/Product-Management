package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.LoanDetailRequest;
import com.technology.apigateway.controller.response.LoanDetailResponse;
import com.technology.apigateway.database.repository.LoanDetailRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.LoanDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loanDetailService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanDetailServiceImpl implements LoanDetailService {

    LoanDetailRepository loanDetailRepository;

    @Override
    public List<LoanDetailResponse> getLoanById(LoanDetailRequest request) {
        List<LoanDetailResponse> loanList = loanDetailRepository.getLoanDetail(request.getId());
        if (loanList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Loan");
        }
        return loanList;
    }
}
