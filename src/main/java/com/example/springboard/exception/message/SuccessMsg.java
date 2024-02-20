package com.example.springboard.exception.message;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMsg {
    GET_BOARD_SUCCESS(HttpStatus.OK, "게시글 조회 성공"),
    DELETE_BOARD_SUCCESS(HttpStatus.OK, "게시글 삭제 완료"),
    DELETE_COMMENT_SUCCESS(HttpStatus.OK, "댓글 삭제 완료"),

    CREATE_BOARD_SUCCESS(HttpStatus.CREATED, "게시글 작성 완료"),
    CREATE_COMMENT_SUCCESS(HttpStatus.CREATED, "댓글 작성 완료"),
    UPDATE_BOARD_SUCCESS(HttpStatus.CREATED, "게시글 수정 완료"),
    UPDATE_COMMENT_SUCCESS(HttpStatus.CREATED, "댓글 수정 완료");

    private final HttpStatus code;
    private final String message;
}
