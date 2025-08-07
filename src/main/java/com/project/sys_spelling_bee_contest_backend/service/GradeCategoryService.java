package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeCategoryDTO;

import java.util.List;

public interface GradeCategoryService {
    List<GradeCategoryDTO> listGradeCategory();
    GradeCategoryDTO findGradeCategoryById(Integer idGradeCategory);
}
