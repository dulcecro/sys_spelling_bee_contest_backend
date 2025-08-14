package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.entity.GradeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeCategoryRepository extends JpaRepository<GradeCategory, Integer> {

}
