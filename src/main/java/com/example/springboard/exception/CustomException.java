package com.example.springboard.exception;

import com.example.springboard.exception.message.ExceptionMsg;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class CustomException extends RuntimeException {
    private final int code;
    private String message;

    public CustomException(ExceptionMsg exceptionMsg) {
        this.code = exceptionMsg.getCode();
        this.message = exceptionMsg.getMessage();
    }

}
