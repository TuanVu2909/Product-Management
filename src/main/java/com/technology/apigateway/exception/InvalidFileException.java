package com.technology.apigateway.exception;

import com.technology.apigateway.constant.ErrorCode;

public class InvalidFileException extends BusinessException {

    private static final long serialVersionUID = 7641702942202000228L;

    public InvalidFileException() {
        super(ErrorCode.INVALID_FILE, ErrorCode.INVALID_FILE_DESCRIPTION);
    }

    public InvalidFileException(String message) {
        super(ErrorCode.INVALID_FILE, message);
    }
}
