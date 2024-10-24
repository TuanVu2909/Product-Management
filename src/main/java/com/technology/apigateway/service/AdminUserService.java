package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.AdminUserRequest;
import com.technology.apigateway.controller.request.OperatorEstPaymentRequest;
import com.technology.apigateway.controller.request.OutStandingLoanRequest;
import com.technology.apigateway.database.entity.*;
import com.technology.apigateway.database.entity.status.AdminUserStatus;

import java.util.List;

public interface AdminUserService {

    List<AdminUserRequest> getAllAdminUser();

    List<AdminUser> getAdminUserById(int userid);

    AdminUser findByUserName(String userName);

    AdminUser createAdminUser(AdminUserRequest request);

    UserFile deleteFileById(int id);

    AdminUserStatus updateAdminUser(AdminUserRequest adminUserRequest);

    List<SaleOverview> saleOverview(int userId);

    List<OperatorOverview> operatorOverview(int userId);

    List<OperatorEstPayment> operatorEstPayment(OperatorEstPaymentRequest operatorEstPaymentRequest);

    List<OutStandingLoan> outStandingLoan(OutStandingLoanRequest outStandingLoanRequest);

}
