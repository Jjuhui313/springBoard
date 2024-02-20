package com.example.springboard.exception;

import com.example.springboard.exception.message.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    protected MessageResponse handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getCode());
        return new MessageResponse(e.getCode(), e.getMessage());

    }

}
