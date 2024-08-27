package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.AdminUserRequest;
import com.technology.apigateway.controller.request.OperatorEstPaymentRequest;
import com.technology.apigateway.controller.request.OutStandingLoanRequest;
import com.technology.apigateway.database.entity.AdminUser;
import com.technology.apigateway.database.entity.AdminUserStatus;
import com.technology.apigateway.database.entity.OperatorEstPayment;
import com.technology.apigateway.database.entity.OperatorOverview;
import com.technology.apigateway.database.entity.OutStandingLoan;
import com.technology.apigateway.database.entity.SaleOverview;
import com.technology.apigateway.database.entity.UserFile;

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
