package com.sparta.todojwt.dto;

import com.sparta.todojwt.entity.Todo;
import lombok.Getter;

@Getter
public class CommentSaveResponseDto {
    private final Long id;
    private final String todoTitle;
    private final String todoContent;
    private final String creator;
    private final String content;

    public CommentSaveResponseDto(Long id, String todoTitle, String todoContent,
                                  String creator, String content  ){
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.creator = creator;
        this.content = content;
    }
}
