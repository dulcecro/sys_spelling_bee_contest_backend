package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.model.GradeCategory;
import com.project.sys_spelling_bee_contest_backend.service.GradeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/gradeCategory")
public class GradeCategoryController {
    @Autowired
    private GradeCategoryService gradeCategoryService;

    @GetMapping()
    public List<GradeCategory> listGradeCategory() {
        return gradeCategoryService.listGradeCategory();
    }
}
