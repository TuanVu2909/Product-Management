package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.AdminUserRequest;
import com.technology.apigateway.controller.request.OperatorEstPaymentRequest;
import com.technology.apigateway.controller.request.OutStandingLoanRequest;
import com.technology.apigateway.database.entity.AdminUser;
import com.technology.apigateway.database.entity.status.AdminUserStatus;
import com.technology.apigateway.database.entity.OperatorEstPayment;
import com.technology.apigateway.database.entity.OperatorOverview;
import com.technology.apigateway.database.entity.OutStandingLoan;
import com.technology.apigateway.database.entity.SaleOverview;
import com.technology.apigateway.database.entity.UserFile;
import com.technology.apigateway.database.repository.AdminUserRepository;
import com.technology.apigateway.database.repository.AdminUserStatusRepository;
import com.technology.apigateway.database.repository.OperatorEstPaymentRepository;
import com.technology.apigateway.database.repository.OperatorOverviewRepository;
import com.technology.apigateway.database.repository.OutStandingLoanRepository;
import com.technology.apigateway.database.repository.SaleOverviewRepository;
import com.technology.apigateway.database.repository.UserFileRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.AdminUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("adminUserService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminUserServiceImpl implements AdminUserService {

    AdminUserRepository adminUserRepository;

    AdminUserStatusRepository adminUserStatusRepository;

    OperatorEstPaymentRepository operatorEstPaymentRepository;

    SaleOverviewRepository saleOverviewRepository;

    OperatorOverviewRepository operatorOverviewRepository;

    UserFileRepository userFileRepository;

    OutStandingLoanRepository outStandingLoanRepository;

    @Override
    public List<AdminUserRequest> getAllAdminUser() {
        List<AdminUser> adminUserList = adminUserRepository.getAllAdminUser();
        if (adminUserList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Admin User");
        }
        List<AdminUserRequest> adminUserRequestList = new ArrayList<>();
        for (AdminUser adminUser : adminUserList) {
            AdminUserRequest adminUserRequest = new AdminUserRequest();
            adminUserRequest.setUserId(adminUser.getUserId());
            adminUserRequest.setUserName(adminUser.getUserName());
            adminUserRequest.setPassword(adminUser.getPassword());
            adminUserRequest.setFullName(adminUser.getFullName());
            adminUserRequest.setIdCode(adminUser.getIdCode());
            adminUserRequest.setIdPlace(adminUser.getIdPlace());
            adminUserRequest.setDob(adminUser.getDob());
            adminUserRequest.setSex(adminUser.getSex());
            adminUserRequest.setPhone(adminUser.getPhone());
            adminUserRequest.setEmail(adminUser.getEmail());
            adminUserRequest.setLoginFail(adminUser.getLoginFail());
            adminUserRequest.setRegDate(adminUser.getRegDate());
            adminUserRequest.setWhoCreated(adminUser.getWhoCreated());
            adminUserRequest.setRole(adminUser.getRole());
            adminUserRequest.setBranch(adminUser.getBranch());
            adminUserRequest.setStatus(adminUser.getStatus());
            adminUserRequest.setGid(adminUser.getGid());
            adminUserRequestList.add(adminUserRequest);
        }
        return adminUserRequestList;
    }

    @Override
    public List<AdminUser> getAdminUserById(int userid) {
        List<AdminUser> adminUserList = adminUserRepository.getAdminUserById(userid);
        if (adminUserList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Admin");
        }
        return adminUserList;
    }

    @Override
    public AdminUser findByUserName(String userName) {
        return adminUserRepository.getByUserName(userName);
    }

    @Override
    public AdminUser createAdminUser(AdminUserRequest request) {
        AdminUser adminUser = adminUserRepository.getByUserName(request.getUserName());
        if (adminUser != null) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Username đã bị trùng");
        }
        try {
            adminUser = adminUserRepository.createUser(
                    request.getUserName(),
                    request.getPassword(),
                    request.getFullName(),
                    request.getIdCode(),
                    request.getIdPlace(),
                    request.getDob(),
                    request.getSex(),
                    request.getPhone(),
                    request.getEmail(),
                    request.getRole(),
                    request.getBranch(),
                    request.getGid());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return adminUser;
    }

    @Override
    public UserFile deleteFileById(int id) {
        userFileRepository.deleteById(id);
        return null;
    }

    @Override
    public AdminUserStatus updateAdminUser(AdminUserRequest adminUserRequest) {
        AdminUserStatus adminUserStatus;
        try {
            adminUserStatus = adminUserStatusRepository.updateUser(
                    adminUserRequest.getUserId(),
                    adminUserRequest.getUserName(),
                    adminUserRequest.getPassword(),
                    adminUserRequest.getFullName(),
                    adminUserRequest.getIdCode(),
                    adminUserRequest.getIdPlace(),
                    adminUserRequest.getDob(),
                    adminUserRequest.getSex(),
                    adminUserRequest.getPhone(),
                    adminUserRequest.getEmail(),
                    adminUserRequest.getRole(),
                    adminUserRequest.getBranch(),
                    adminUserRequest.getGid());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return adminUserStatus;
    }

    // so lieu tong quan
    @Override
    public List<SaleOverview> saleOverview(int userId) {
        List<SaleOverview> adminUsers = saleOverviewRepository.saleOverview(userId);
        if (adminUsers.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found");
        }
        return adminUsers;
    }

    @Override
    public List<OperatorOverview> operatorOverview(int userId) {
        List<OperatorOverview> operatorOverview = operatorOverviewRepository.operatorOverview(userId);
        if (operatorOverview.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found");
        }
        return operatorOverview;
    }

    @Override
    public List<OperatorEstPayment> operatorEstPayment(OperatorEstPaymentRequest operatorEstPaymentRequest) {
        List<OperatorEstPayment> operatorEstPaymentList = operatorEstPaymentRepository.operatorEstPayment(
                operatorEstPaymentRequest.getFullname(),
                operatorEstPaymentRequest.getMobile(),
                operatorEstPaymentRequest.getIdnumber(),
                operatorEstPaymentRequest.getBranch(),
                operatorEstPaymentRequest.getUserId(),
                operatorEstPaymentRequest.getDocumentNo(),
                operatorEstPaymentRequest.getFromDate(),
                operatorEstPaymentRequest.getToDate());
        if (operatorEstPaymentList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, ErrorCode.NOT_FOUND_OPERATOR);
        }
        return operatorEstPaymentList;
    }

    @Override
    public List<OutStandingLoan> outStandingLoan(OutStandingLoanRequest outStandingLoanRequest) {
        List<OutStandingLoan> outStandingLoanList = outStandingLoanRepository.outStandingLoan(
                outStandingLoanRequest.getUserId(),
                outStandingLoanRequest.getFullName(),
                outStandingLoanRequest.getBranch(),
                outStandingLoanRequest.getFromDate(),
                outStandingLoanRequest.getToDate());
        if (outStandingLoanList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, ErrorCode.NOT_FOUND_OPERATOR);
        }
        return outStandingLoanList;
    }
}