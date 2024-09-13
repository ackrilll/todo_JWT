package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class UserSaveRequestDto {
    private String username;
    private String password;
    private String email;
}
