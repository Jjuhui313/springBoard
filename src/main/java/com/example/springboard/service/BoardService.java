package com.example.springboard.service;

import com.example.springboard.dto.BoardListResponseDto;
import com.example.springboard.dto.BoardRequestDto;
import com.example.springboard.dto.BoardResponseDto;
import com.example.springboard.entity.Board;
import com.example.springboard.entity.DeleteStatus;
import com.example.springboard.exception.CustomException;
import com.example.springboard.exception.message.ExceptionMsg;
import com.example.springboard.exception.message.MessageResponse;
import com.example.springboard.exception.message.SuccessMsg;
import com.example.springboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public ResponseEntity<MessageResponse<BoardResponseDto>> createBoard(BoardRequestDto boardRequestDto) {
        Board board = Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .deleteStatus(DeleteStatus.ACTIVE)
                .build();
        boardRepository.save(board);

        return MessageResponse.success(SuccessMsg.CREATE_BOARD_SUCCESS, BoardResponseDto.from(board));
    }

    public ResponseEntity<MessageResponse<List<BoardListResponseDto>>> getBoardList(int page, int pageSize) {
        return MessageResponse.success(SuccessMsg.GET_BOARD_SUCCESS, boardRepository.findAllByDeleteStatus(
                DeleteStatus.ACTIVE,
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "id"))
        ).map(BoardListResponseDto::from).toList());
    }

    public ResponseEntity<MessageResponse<BoardResponseDto>> getBoard(Long boardId) {
        return MessageResponse.success(SuccessMsg.GET_BOARD_SUCCESS, boardRepository.findBoardWithCommentsByBoardIdAAndDeleteStatus(
                boardId, DeleteStatus.ACTIVE)
                .map(BoardResponseDto::from)
                .orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_BOARD)));
    }

    @Transactional
    public ResponseEntity<MessageResponse<BoardResponseDto>> updateBoard(Long boardId, BoardRequestDto boardRequestDto) {
        Optional<Board> findBoard = boardRepository.findByIdAndDeleteStatus(boardId, DeleteStatus.ACTIVE);
        Board board = findBoard.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_BOARD));
        board.changeBoard(boardRequestDto);
        return MessageResponse.success(SuccessMsg.UPDATE_BOARD_SUCCESS, BoardResponseDto.from(board));
    }

    @Transactional
    public ResponseEntity<MessageResponse<String>> deleteBoard(Long boardId) {
        Optional<Board> findBoard = boardRepository.findByIdAndDeleteStatus(boardId, DeleteStatus.ACTIVE);
        Board board = findBoard.orElseThrow(() -> new CustomException(ExceptionMsg.NOT_FOUND_BOARD));
        boardRepository.delete(board);
        return MessageResponse.success(SuccessMsg.DELETE_BOARD_SUCCESS, "");
    }
}
