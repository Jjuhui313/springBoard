package com.example.springboard.dto;

import com.example.springboard.entity.Board;
import com.example.springboard.entity.DeleteStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListResponseDto {
    private Long id;
    private String title;

    public static BoardListResponseDto from(Board board) {
        return new BoardListResponseDto(
                board.getId(),
                board.getTitle()
        );
    }
}
