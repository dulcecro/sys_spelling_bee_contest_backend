package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.model.Grade;
import com.project.sys_spelling_bee_contest_backend.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee")
public class GradeController {
    @Autowired
    public GradeService gradeService;

    @GetMapping("grade")
    private List<Grade> listGrade(){
        return gradeService.listGrades();
    }
}
