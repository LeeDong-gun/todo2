package com.example.todo2.entity;

import com.example.todo2.dto.TodoResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "todo")
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Todo() {
    }

    public Todo (String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

}
