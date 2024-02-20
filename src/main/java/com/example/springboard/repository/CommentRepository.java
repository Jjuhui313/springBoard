package com.example.springboard.repository;

import com.example.springboard.entity.Board;
import com.example.springboard.entity.Comment;
import com.example.springboard.entity.DeleteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByBoardAndIdAndDeleteStatus(Board board, Long id, DeleteStatus deleteStatus);
}
