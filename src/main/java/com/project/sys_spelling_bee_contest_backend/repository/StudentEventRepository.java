package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.entity.StudentEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentEventRepository extends JpaRepository<StudentEvent, Integer> {
    List<StudentEvent> findStudentEventByIdGradeDetail_IdGrade(Integer idGrade);
}