package com.sparta.todojwt.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class TodoSimpleResponseDto {
    private final String todoTitle;
    private final String todoContent;
    private final int commentNum;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String creatorName;

    public TodoSimpleResponseDto(String todoTitle, String todoContent, int commentNum,
                                 LocalDateTime createdAt, LocalDateTime modifiedAt, String creatorName) {
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.commentNum = commentNum;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.creatorName = creatorName;
    }
}
