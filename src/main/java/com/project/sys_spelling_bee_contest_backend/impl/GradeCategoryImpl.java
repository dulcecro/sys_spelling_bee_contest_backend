package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeCategoryDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.GradeCategoryMapper;
import com.project.sys_spelling_bee_contest_backend.entity.GradeCategory;
import com.project.sys_spelling_bee_contest_backend.repository.GradeCategoryRepository;
import com.project.sys_spelling_bee_contest_backend.service.GradeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeCategoryImpl implements GradeCategoryService {
    private final GradeCategoryRepository gradeCategoryRepository;
    private final GradeCategoryMapper gradeCategoryMapper;

    @Override // Define the overwrite of method
    public List<GradeCategoryDTO> listGradeCategory() {
        List<GradeCategory> gradeCategory = gradeCategoryRepository.findAll();

        if(gradeCategory.isEmpty()) {
            throw new RuntimeException("The list of grade with category is empty");
        }

        return gradeCategory.stream().map(gradeCategoryMapper::gradeCategoryToDTO).toList();
    }

    @Override
    public GradeCategoryDTO findGradeCategoryById(Integer idGradeCategory){
        return gradeCategoryRepository.findById(idGradeCategory).
                map(gradeCategoryMapper::gradeCategoryToDTO).
                orElseThrow(() -> new RuntimeException("Grade category not found with ID: " + idGradeCategory));
    }

    @Override
    public GradeCategory getIdGradeCategory(Integer idGrade, Integer idCategory){
        return gradeCategoryRepository.findByIdGradeDetalle_IdGrade_AndIdCategoryDetalle_IdCategory(idGrade, idCategory)
                .orElseThrow(()-> new RuntimeException("Doesn't exits combination with idGrade " + idGrade + " and idCategory: " + idCategory));
    }
}
