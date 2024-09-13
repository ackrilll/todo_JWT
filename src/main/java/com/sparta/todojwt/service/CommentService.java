package com.sparta.todojwt.service;

import com.sparta.todojwt.dto.*;
import com.sparta.todojwt.entity.Comment;
import com.sparta.todojwt.entity.Todo;
import com.sparta.todojwt.entity.User;
import com.sparta.todojwt.repository.CommentRepository;
import com.sparta.todojwt.repository.TodoRepository;
import com.sparta.todojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(AuthUser authUser, Long todoId, CommentSaveRequestDto commentSaveRequestDto) {
        User user = userRepository.findById(authUser.getId()).orElseThrow(()->new NullPointerException("유저 못찾음"));
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("일정 못찾음"));
        Comment comment = new Comment(commentSaveRequestDto.getComment(),todo,user);
        Comment savedComment = commentRepository.save(comment);
        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getTodo().getTitle(),
                savedComment.getTodo().getTodo(),
                savedComment.getUser().getName(),
                savedComment.getContent()
        );
    }

    public CommentResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new NullPointerException("댓글 못찾음"));
        return new CommentResponseDto(comment.getId(),comment.getUser().getName(),comment.getContent());
    }

    public List<CommentResponseDto> getComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment.getId(),comment.getUser().getName(),comment.getContent());
            commentResponseDtos.add(commentResponseDto);
        }
        return commentResponseDtos;
    }

    @Transactional
    public CommentResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("댓글 못찾음"));
        comment.update(commentUpdateRequestDto.getContent());
        return new CommentResponseDto(comment.getId(),comment.getUser().getName(),comment.getContent());
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("댓글 못찾음"));
        commentRepository.delete(comment);
    }
}
