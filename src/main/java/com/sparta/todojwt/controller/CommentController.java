package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.AuthUser;
import com.sparta.todojwt.dto.CommentResponseDto;
import com.sparta.todojwt.dto.CommentSaveRequestDto;
import com.sparta.todojwt.dto.CommentSaveResponseDto;
import com.sparta.todojwt.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/todos/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long commentId){
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @GetMapping("/todos/comments")
    public ResponseEntity<List<CommentResponseDto>> getComments(){
        return ResponseEntity.ok(commentService.getComments());
    }

}
