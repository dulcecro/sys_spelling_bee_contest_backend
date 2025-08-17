package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeCategoryDTO;
import com.project.sys_spelling_bee_contest_backend.entity.GradeCategory;

import java.util.List;
import java.util.Optional;

public interface GradeCategoryService {
    List<GradeCategoryDTO> listGradeCategory();
    GradeCategoryDTO findGradeCategoryById(Integer idGradeCategory);
    GradeCategory getIdGradeCategory(Integer idGrade, Integer idCategory);
}
