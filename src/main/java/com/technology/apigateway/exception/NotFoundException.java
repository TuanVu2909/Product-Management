package com.technology.apigateway.exception;

import com.technology.apigateway.constant.ErrorCode;

public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 7641702942202000228L;

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND_ENTITY, ErrorCode.NOT_FOUND_ENTITY_DESCRIPTION);
    }

    public NotFoundException(String message) {
        super(ErrorCode.NOT_FOUND_ENTITY, message);
    }

}
