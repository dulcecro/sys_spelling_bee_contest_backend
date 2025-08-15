package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundRepository extends JpaRepository<Round, Integer> {
    List<Round> findByIdGradeRound_IdGrade(Integer idGrade);
}
