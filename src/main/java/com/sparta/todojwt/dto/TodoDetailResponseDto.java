package com.sparta.todojwt.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoDetailResponseDto {
    private final Long id;
    private final String title;
    private final String todo;
    private final String creator;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
    public TodoDetailResponseDto(Long id, String title, String todo,
                                 String creator, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.creator = creator;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
