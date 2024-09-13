package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class ManagerResponseDto {
    private Long managerId;
    private String managerName;
    private String managerEmail;

    public ManagerResponseDto(Long managerId, String managerName, String managerEmail) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
    }
}
