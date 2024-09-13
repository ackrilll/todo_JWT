package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class ManagerSaveResponseDto {
    private final String todoTitle;
    private final Long managerId;
    private final String managerName;
    private final String todoContent;

    public ManagerSaveResponseDto(String todoTitle, Long managerId, String managerName,String todoContent){
        this.todoTitle = todoTitle;
        this.managerId = managerId;
        this.managerName = managerName;
        this.todoContent = todoContent;
    }
}
