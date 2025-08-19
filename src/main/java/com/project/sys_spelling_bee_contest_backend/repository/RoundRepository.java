package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoundRepository extends JpaRepository<Round, Integer> {
    List<Round> findByIdGradeCategoryRound_IdGradeDetalle_IdGrade(Integer idGrade);
    Round findTopByIdGradeCategoryRound_IdGradeDetalle_IdGradeOrderByIdRoundDesc(Integer idGrade);
}
