package com.technology.apigateway.exception;

import com.technology.apigateway.constant.ErrorCode;

public class InputInvalidException extends BusinessException {

    private static final long serialVersionUID = 7641702942202000228L;

    public InputInvalidException() {
        super(ErrorCode.INVALID_DATA_REQUEST, ErrorCode.INVALID_DATA_REQUEST_DESCRIPTION);
    }

    public InputInvalidException(String message) {
        super(ErrorCode.INVALID_DATA_REQUEST, message);
    }

    public InputInvalidException(String objectName, String message) {
        super(ErrorCode.INVALID_DATA_REQUEST, objectName + ":" + message);
    }

}