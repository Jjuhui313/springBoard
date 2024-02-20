package com.example.springboard.entity;

import com.example.springboard.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE board SET DELETE_STATUS = 'DELETE' WHERE id = ?")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board")
    @SQLRestriction("DELETE_STATUS = 'ACTIVE'")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    private Board(String title, String content, DeleteStatus deleteStatus) {
        this.title = title;
        this.content = content;
        this.deleteStatus = deleteStatus;
    }

    public Board addComment(String commentBody) {
        Comment comment = Comment.builder()
                .content(commentBody)
                .board(this)
                .deleteStatus(DeleteStatus.ACTIVE)
                .build();

        this.getComments().add(comment);
        return this;
    }

    public void changeBoard(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
    }
}
