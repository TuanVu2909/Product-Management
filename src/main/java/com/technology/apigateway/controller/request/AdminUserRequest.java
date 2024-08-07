package com.technology.apigateway.controller.request;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminUserRequest {
    private String userId;
    private String userName;
    private String password;
    private String fullName;
    private String idCode;
    private String idPlace;
    private Date dob;
    private String sex;
    private String phone;
    private String email;
    private int loginFail;
    private Date regDate;
    private String whoCreated;
    private String role;
    private String branch;
    private int status;
    private String gid;
}
