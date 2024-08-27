package com.technology.apigateway.controller.response;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import com.technology.apigateway.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.technology.apigateway.constant.Constants;
import com.technology.apigateway.utils.StringUtil;

public abstract class BaseResponse<S> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected <T> ResponseEntity<ApiResponse<T>> response(ApiResponse<T> response) {
		if (response == null) {
			throw new IllegalArgumentException("Please set responseBean.");
		}

		if (StringUtil.isEmty(response.getStatus())) {
			response.setStatus(Constants.SUCCESS);
		}
		return new ResponseEntity<ApiResponse<T>>(response, HttpStatus.OK);
	}

	protected ResponseEntity<byte[]> response(String fileName, byte[] file) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition",
				"attachment; filename*=UTF-8''" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()));

		// Create response
		return ResponseEntity.ok().headers(headers).contentLength(file.length)
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(file);
	}

	protected <T> ApiResponse<T> toResult(Optional<T> optional) {
		if (!optional.isPresent())
			throw new NotFoundException();
		return toResult(optional.get());
	}

	protected <T> ApiResponse<T> toResult(T t) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setStatus(Constants.SUCCESS);
		response.setMessage(Constants.MESSAGE_SUCCESS);
		response.setData(t);
		return response;
	}

	protected <T> ApiResponse<T> toResult(String status, String message, T t) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setStatus(status);
		response.setMessage(message);
		response.setData(t);
		return response;
	}

	protected <T> ApiResponse<T> toErrorResult(String status, String message, String errorCode, String errorDetail) {
		ApiResponse<T> response = new ApiResponse<T>();
		response.setStatus(status);
		response.setMessage(message);
		return response;
	}

}
