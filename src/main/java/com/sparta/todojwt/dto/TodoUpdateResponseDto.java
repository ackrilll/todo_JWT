package com.sparta.todojwt.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateResponseDto {
    private final Long id;
    private final String title;
    private final String todo;
    private final String creatorName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoUpdateResponseDto(Long id, String title, String todo, String creatorName,
                               LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.creatorName = creatorName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }

}
