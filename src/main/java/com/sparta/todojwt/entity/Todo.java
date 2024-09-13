package com.sparta.todojwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String todo;

    public Todo(User user, String title, String todo){
        this.user = user;
        this.title = title;
        this.todo = todo;
    }

    public void update(String title, String todo) {
        this.title = title;
        this.todo = todo;
    }
}
