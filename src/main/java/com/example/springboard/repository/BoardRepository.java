package com.example.springboard.repository;

import com.example.springboard.entity.Board;
import com.example.springboard.entity.DeleteStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByIdAndDeleteStatus(Long BoardId, DeleteStatus deleteStatus);
    Page<Board> findAllByDeleteStatus(DeleteStatus deleteStatus, Pageable pageable);

    @Query("SELECT b From Board b LEFT JOIN FETCH b.comments c WHERE b.id = :boardId AND b.deleteStatus = :deletedStatus")
    Optional<Board> findBoardWithCommentsByBoardIdAAndDeleteStatus(@Param("boardId") Long boardId, @Param("deletedStatus") DeleteStatus deletedStatus);
}
