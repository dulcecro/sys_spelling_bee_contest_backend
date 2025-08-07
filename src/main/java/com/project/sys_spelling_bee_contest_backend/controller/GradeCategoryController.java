package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeCategoryDTO;
import com.project.sys_spelling_bee_contest_backend.service.GradeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/gradeCategory")
@RequiredArgsConstructor
public class GradeCategoryController {
    private final GradeCategoryService gradeCategoryService;

    @GetMapping()
    public ResponseEntity<List<GradeCategoryDTO>> listGradeCategory() {
        return ResponseEntity.ok(gradeCategoryService.listGradeCategory());
    }
}
