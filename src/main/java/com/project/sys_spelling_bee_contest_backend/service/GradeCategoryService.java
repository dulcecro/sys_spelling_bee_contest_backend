package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.model.GradeCategory;
import com.project.sys_spelling_bee_contest_backend.repository.GradeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeCategoryService {
    @Autowired
    private GradeCategoryRepository gradeCategoryRepository;

    public List<GradeCategory> listGradeCategory() {
        return gradeCategoryRepository.findAll();
    }
}
