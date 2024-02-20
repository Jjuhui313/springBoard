package com.example.springboard.service;

import com.example.springboard.dto.BoardResponseDto;
import com.example.springboard.dto.CommentRequestDto;
import com.example.springboard.dto.CommentResponseDto;
import com.example.springboard.entity.Board;
import com.example.springboard.entity.Comment;
import com.example.springboard.entity.DeleteStatus;
import com.example.springboard.exception.CustomException;
import com.example.springboard.exception.message.ExceptionMsg;
import com.example.springboard.exception.message.MessageResponse;
import com.example.springboard.exception.message.SuccessMsg;
import com.example.springboard.repository.BoardRepository;
import com.example.springboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public MessageResponse<BoardResponseDto> createComment(Long boardId, CommentRequestDto commentRequestDto) {
        Optional<Board> findBoard = boardRepository.findBoardWithCommentsByBoardIdAAndDeleteStatus(boardId, DeleteStatus.ACTIVE);
        Board board = findBoard.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_BOARD));

        board.addComment(commentRequestDto.getContent());
        boardRepository.save(board);

        return new MessageResponse<>(SuccessMsg.CREATE_COMMENT_SUCCESS.getCode(), SuccessMsg.CREATE_COMMENT_SUCCESS.getMessage(), BoardResponseDto.from(board));
    }

    @Transactional
    public MessageResponse<BoardResponseDto> updateComment(Long boardId, Long commentId, CommentRequestDto commentRequestDto) {
        Optional<Board> findBoard = boardRepository.findByIdAndDeleteStatus(boardId, DeleteStatus.ACTIVE);
        Board board = findBoard.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_BOARD));

        Optional<Comment> findComment = commentRepository.findByBoardAndIdAndDeleteStatus(board, commentId, DeleteStatus.ACTIVE);
        Comment comment = findComment.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_COMMENT));
        comment.changeComment(commentRequestDto);

        return new MessageResponse<>(SuccessMsg.UPDATE_COMMENT_SUCCESS.getCode(), SuccessMsg.UPDATE_COMMENT_SUCCESS.getMessage(), BoardResponseDto.from(board));
    }

    @Transactional
    public MessageResponse<String> deleteComment(Long boardId, Long commentId) {
        Optional<Board> findBoard = boardRepository.findByIdAndDeleteStatus(boardId, DeleteStatus.ACTIVE);
        Board board = findBoard.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_BOARD));

        Optional<Comment> findComment = commentRepository.findByBoardAndIdAndDeleteStatus(board, commentId, DeleteStatus.ACTIVE);
        Comment comment = findComment.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_COMMENT));

        commentRepository.delete(comment);

        return new MessageResponse<>(SuccessMsg.DELETE_COMMENT_SUCCESS.getCode(), SuccessMsg.DELETE_COMMENT_SUCCESS.getMessage());
    }


}
