package com.example.springboard.controller;

import com.example.springboard.dto.BoardListResponseDto;
import com.example.springboard.dto.BoardRequestDto;
import com.example.springboard.dto.BoardResponseDto;
import com.example.springboard.exception.message.MessageResponse;
import com.example.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<MessageResponse<BoardResponseDto>> createBoard(
            @RequestBody BoardRequestDto boardRequestDto
    ) {
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping
    public ResponseEntity<MessageResponse<List<BoardListResponseDto>>> getBoardList(
            @RequestParam("page") int page,
            @RequestParam("pageSize") int pageSize
    ) {
        return boardService.getBoardList(page, pageSize);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<MessageResponse<BoardResponseDto>> getBoard(
            @PathVariable Long boardId
    ) {
        return boardService.getBoard(boardId);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<MessageResponse<BoardResponseDto>> updateBoard(
            @PathVariable Long boardId,
            @RequestBody BoardRequestDto boardRequestDto
    ) {
        return boardService.updateBoard(boardId, boardRequestDto);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<MessageResponse<String>> deleteBoard(
            @PathVariable Long boardId
    ) {
        return boardService.deleteBoard(boardId);
    }


}
