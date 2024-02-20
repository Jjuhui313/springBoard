package com.example.springboard.dto;

import com.example.springboard.entity.Board;
import com.example.springboard.entity.DeleteStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private DeleteStatus deleteStatus;
    private List<CommentResponseDto> commentResponses;

    public static BoardResponseDto from(Board board) {
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getDeleteStatus(),
                board.getComments().stream().map(CommentResponseDto::from).collect(Collectors.toList())
        );
    }


}
