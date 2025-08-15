package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.entity.RoundStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundStudentRepository extends JpaRepository<RoundStudent, Integer> {
    List<RoundStudent> findAllByNumberRoundAndIdStudentEventRound_IdGradeDetail_IdGradeOrderByIdStudentEventRound_IdStudentDetail_PaternalSurnameAscIdStudentEventRound_IdStudentDetail_MaternalSurnameAsc(Integer numberRound, Integer idGrade);
}
