package com.example.springboard.exception.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MessageResponse<T> {
    private int statusCode;

    private String result;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    public MessageResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.result = message;
    }

    public MessageResponse(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.result = message;
        this.data = data;
    }




}
