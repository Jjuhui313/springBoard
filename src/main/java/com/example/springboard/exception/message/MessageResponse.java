package com.example.springboard.exception.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse<T> {
    private int statusCode;

    private String result;

    private T data;

    public MessageResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.result = message;
    }

    public static <T> ResponseEntity<MessageResponse<T>> success(SuccessMsg successMsg, T data) {
    return ResponseEntity
            .status(successMsg.getCode())
            .body(MessageResponse.<T>builder()
                    .statusCode(successMsg.getCode().value())
                    .result(successMsg.getMessage())
                    .data(data)
                    .build()
            );

    }

    public static ResponseEntity<MessageResponse> fail(ExceptionMsg exceptionMsg) {
        return ResponseEntity
                .status(exceptionMsg.getCode())
                .body(MessageResponse.builder()
                        .statusCode(exceptionMsg.getCode().value())
                        .result(exceptionMsg.getMessage())
                        .build()
                );

    }




}
