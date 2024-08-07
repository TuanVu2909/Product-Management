package com.technology.apigateway.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class GroupUserRequest {
    private String gid;
    private String name;
    private String region;
    private String area;
    private String branch;
    private String role;
    private String gfId;
    private String description;
    private Date createdDate;
    private int status;
}
