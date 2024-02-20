package com.example.springboard.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum SuccessMsg {
    GET_BOARD_SUCCESS(200, "게시글 조회 성공"),
    CREATE_BOARD_SUCCESS(201, "게시글 작성 완료"),
    CREATE_COMMENT_SUCCESS(201, "댓글 작성 완료"),
    UPDATE_BOARD_SUCCESS(201, "게시글 수정 완료"),
    UPDATE_COMMENT_SUCCESS(201, "댓글 수정 완료"),

    DELETE_BOARD_SUCCESS(201, "게시글 삭제 완료"),
    DELETE_COMMENT_SUCCESS(201, "댓글 삭제 완료");

    private final int code;
    private final String message;
}
