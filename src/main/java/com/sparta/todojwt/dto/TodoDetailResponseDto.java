package com.sparta.todojwt.dto;

import com.sparta.todojwt.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoDetailResponseDto {
    private final Long id;
    private final String title;
    private final String todo;
    private final Long creatorId;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;
    private final List<CommentResponseDto> comments;
    public TodoDetailResponseDto(Long id, String title, String todo,
                                 Long creatorId, LocalDateTime createAt, LocalDateTime modifiedAt,
                                 List<Comment> comments)
    {
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for (Comment comment : comments){
            CommentResponseDto commentResponseDto = new CommentResponseDto(
                    comment.getId(),
                    comment.getUser().getName(),
                    comment.getContent()
            );
            commentResponseDtoList.add(commentResponseDto);
        }
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.creatorId = creatorId;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.comments = commentResponseDtoList;
    }
}
