package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class ManagerSaveRequestDto {
    private Long creatorId;
    private Long managerId;
    private Long todoId;
}
