package com.technology.apigateway.service;

import com.technology.apigateway.database.entity.BusinessDate;

import java.util.List;

public interface BusinessDateService {

    List<BusinessDate> getBusinessDates();
}
