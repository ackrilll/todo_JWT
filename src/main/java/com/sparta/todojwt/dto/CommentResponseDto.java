package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String creator;
    private final String content;

    public CommentResponseDto(Long id, String creator, String content  ){
        this.id = id;
        this.creator = creator;
        this.content = content;
    }
}
