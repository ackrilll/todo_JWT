package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.*;
import com.sparta.todojwt.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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

    @PutMapping("/todos/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long commentId,
                                                            @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        return ResponseEntity.ok(commentService.updateComment(commentId, commentUpdateRequestDto));
    }

    @DeleteMapping("/todos/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

}
