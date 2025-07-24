package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
