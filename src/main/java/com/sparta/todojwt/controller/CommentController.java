package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.AuthUser;
import com.sparta.todojwt.dto.CommentSaveRequestDto;
import com.sparta.todojwt.dto.CommentSaveResponseDto;
import com.sparta.todojwt.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(
            AuthUser authUser,
            @PathVariable Long todoId,
            @RequestBody CommentSaveRequestDto commentSaveRequestDto){
        return ResponseEntity.ok(commentService.saveComment(authUser ,todoId, commentSaveRequestDto));
    }

}
