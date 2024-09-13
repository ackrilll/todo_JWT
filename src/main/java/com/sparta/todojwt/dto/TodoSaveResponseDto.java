package com.sparta.todojwt.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {
    private final Long id;
    private final String title;
    private final String todo;
    private final Long creatorId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoSaveResponseDto(Long id, String title, String todo, Long creatorId,
                               LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }
}
