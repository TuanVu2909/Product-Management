package com.technology.apigateway.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ChangePasswordRequest {
    private Integer userId;
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;

}
