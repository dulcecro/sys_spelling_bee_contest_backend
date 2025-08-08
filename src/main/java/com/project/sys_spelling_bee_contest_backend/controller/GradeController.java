package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeDTO;
import com.project.sys_spelling_bee_contest_backend.model.Grade;
import com.project.sys_spelling_bee_contest_backend.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/grade")
@RequiredArgsConstructor
public class GradeController {
    public final GradeService gradeService;

    @GetMapping()
    private ResponseEntity<List<GradeDTO>> listGrade(){
        return ResponseEntity.ok(gradeService.listGrades());
    }
}
