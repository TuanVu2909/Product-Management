package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.LoginRequest;
import com.technology.apigateway.database.entity.AdminUser;
import com.technology.apigateway.database.entity.User;
import com.technology.apigateway.database.repository.AdminUserRepository;
import com.technology.apigateway.database.repository.TokenRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    AdminUserRepository userRepository;


    @Override
    public Map<String, Object> login(LoginRequest loginRequest) {

        AdminUser user = userRepository.getByUserName(loginRequest.getUsername());

        if (user != null) {

            if (!user.getPassword().equals(loginRequest.getPassword())) {
                throw new BusinessException(ErrorCode.FAIL_PASSWORD_LOGIN, ErrorCode.FAIL_PASSWORD_LOGIN_DESCRIPTION);
            }

            if (user.getLoginFail() > 4) {
                throw new BusinessException(ErrorCode.FAIL_PASSWORD_LOGIN, ErrorCode.FAIL_PASSWORD_LOGIN_DESCRIPTION);
            } else {

            }

            // GroupFunctionModel groupFunction = new GroupFunctionModel();
            // try {
            //     groupFunction = DataLoader.groupFunction.stream()
            //             .filter(item -> item.getGroupId()
            //                     .equals(groupUserRepository.findByGid(user.getGid()).getGfid()))
            //             .toList().get(0);
            // } catch (Exception e) {
            //     groupFunction = null;
            // }

            // List<Branch> branchEntity = new ArrayList<>();
            // try {
            //     branchEntity = branchRepository.getBranchByUserId(user.getUserId());
            // } catch (Exception e) {
            //     throw new BusinessException(ErrorCode.ACCOUNT_NOT_UPDATED, ErrorCode.ACCOUNT_NOT_UPDATED_DESCRIPTION);
            // }

            Map<String, Object> map = new HashMap<>();
            map.put("User", user);
            // map.put("GroupFunction", user.getRole().equals("ADMIN") ? "ALL" : groupFunction);
            // map.put("Branch", branchEntity);

            return map;
        } else {
            throw new BusinessException(ErrorCode.FAIL_LOGIN, ErrorCode.FAIL_LOGIN_DESCRIPTION);
        }
    }

    @Override
    public User getUser() {
        User user = tokenRepository.findByUsername("vita");
        System.out.println(user.getPassword());
        return user;
    }

}
