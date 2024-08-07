package com.technology.apigateway.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long expired;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
