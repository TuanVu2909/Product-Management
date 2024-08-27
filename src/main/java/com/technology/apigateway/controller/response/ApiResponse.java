package com.technology.apigateway.controller.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ApiResponse<T> implements Serializable{
  private static final long serialVersionUID = 1L;
  
  protected String status;
  protected String message;
  @JsonInclude(Include.NON_NULL)
  protected ErrorInfo errorInfo;
  
  @JsonInclude(Include.NON_NULL)
  protected T data;
  
}
