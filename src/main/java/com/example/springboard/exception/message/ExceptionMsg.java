package com.example.springboard.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMsg {


    ALREADY_DELETE_BOARD(400, "이미 삭제된 게시글입니다."),
    ALREADY_DELETE_COMMENT(400, "이미 삭제된 댓글입니다."),
    NOT_FOUND_BOARD(404, "존재하지 않는 게시글입니다."),
    NOT_FOUND_COMMENT(404, "존재하지 않는 댓글입니다.");

    private final int code;
    private final String message;
}
