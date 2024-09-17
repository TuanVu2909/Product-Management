package com.technology.apigateway.service.impl;

import com.technology.apigateway.database.entity.BusinessDate;
import com.technology.apigateway.database.repository.BusinessDateRepository;
import com.technology.apigateway.service.BusinessDateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("businessDateService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessDateServiceImpl implements BusinessDateService {

    BusinessDateRepository businessDateRepository;


    @Override
    public List<BusinessDate> getBusinessDates() {
        List<BusinessDate> businessDateList =  businessDateRepository.getBusinessDate("CURRDATE");
        return businessDateList;
    }
}
