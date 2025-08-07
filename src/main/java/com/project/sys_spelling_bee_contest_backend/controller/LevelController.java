package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.LevelDTO;
import com.project.sys_spelling_bee_contest_backend.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/level")
@RequiredArgsConstructor
public class LevelController {
    private final LevelService levelService;

    @GetMapping()
    public ResponseEntity<List<LevelDTO>> listLevels(){
        return ResponseEntity.ok(levelService.listLevels());
    }

}
