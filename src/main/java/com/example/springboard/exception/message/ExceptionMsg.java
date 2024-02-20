package com.example.springboard.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionMsg {


    ALREADY_DELETE_BOARD(HttpStatus.BAD_REQUEST, "이미 삭제된 게시글입니다."),
    ALREADY_DELETE_COMMENT(HttpStatus.BAD_REQUEST, "이미 삭제된 댓글입니다."),
    NOT_FOUND_BOARD(HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."),
    NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND, "존재하지 않는 댓글입니다.");

    private final HttpStatus code;
    private final String message;
}
