package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.entity.GradeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeCategoryRepository extends JpaRepository<GradeCategory, Integer> {
    Optional<GradeCategory> findByIdGradeDetalle_IdGrade_AndIdCategoryDetalle_IdCategory(int idGrade, int idCategory);
}
