package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.AuthUser;
import com.sparta.todojwt.dto.ManagerSaveRequestDto;
import com.sparta.todojwt.dto.ManagerSaveResponseDto;
import com.sparta.todojwt.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @PostMapping("/managers")
    public ResponseEntity<ManagerSaveResponseDto> saveManager(
            AuthUser authUser,
            @RequestBody ManagerSaveRequestDto managerSaveRequestDto){
        return ResponseEntity.ok(managerService.saveManager(authUser,managerSaveRequestDto));
    }
}
