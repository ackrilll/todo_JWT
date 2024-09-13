package com.sparta.todojwt.dto;

import com.sparta.todojwt.entity.Comment;
import com.sparta.todojwt.entity.Manager;
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
    private final List<ManagerResponseDto> managers;
    public TodoDetailResponseDto(Long id, String title, String todo,
                                 Long creatorId, LocalDateTime createAt, LocalDateTime modifiedAt,
                                 List<Comment> comments, List<Manager> managers)
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

        List<ManagerResponseDto> managerResponseDtoList = new ArrayList<>();
        for (Manager manager : managers){
            ManagerResponseDto managerResponseDto = new ManagerResponseDto(
                    manager.getUser().getId(),
                    manager.getUser().getName(),
                    manager.getUser().getEmail()
            );
            managerResponseDtoList.add(managerResponseDto);
        }
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.creatorId = creatorId;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.comments = commentResponseDtoList;
        this.managers = managerResponseDtoList;
    }
}
