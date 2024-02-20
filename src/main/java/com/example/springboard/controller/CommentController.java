package com.example.springboard.controller;

import com.example.springboard.dto.BoardResponseDto;
import com.example.springboard.dto.CommentRequestDto;
import com.example.springboard.dto.CommentResponseDto;
import com.example.springboard.exception.message.MessageResponse;
import com.example.springboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{boardId}/comment")
    public MessageResponse<BoardResponseDto> createComment(
            @PathVariable Long boardId,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        return commentService.createComment(boardId, commentRequestDto);
    }

    @PutMapping("/{boardId}/comment/{commentId}")
    public MessageResponse<BoardResponseDto> updateComment(
            @PathVariable Long boardId,
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        return commentService.updateComment(boardId, commentId, commentRequestDto);
    }

    @DeleteMapping("/{boardId}/comment/{commentId}")
    public MessageResponse<String> deleteComment(
            @PathVariable Long boardId,
            @PathVariable Long commentId
    ) {
        return commentService.deleteComment(boardId, commentId);
    }

}
