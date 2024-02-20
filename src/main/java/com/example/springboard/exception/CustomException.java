package com.example.springboard.exception;

import com.example.springboard.exception.message.ExceptionMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ExceptionMsg exceptionMsg;
}
