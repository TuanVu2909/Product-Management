package com.technology.apigateway.controller.request;

import java.sql.Date;
import java.time.LocalDateTime;

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

public class AddCommentRequest {
    private Integer userId;
    private Integer loanRegId;
    private String comment;

}
