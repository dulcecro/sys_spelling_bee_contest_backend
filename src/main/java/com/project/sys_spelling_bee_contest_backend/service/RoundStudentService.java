package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;
import com.project.sys_spelling_bee_contest_backend.DTO.WordDTO;
import com.project.sys_spelling_bee_contest_backend.entity.GradeCategory;
import com.project.sys_spelling_bee_contest_backend.entity.Round;
import com.project.sys_spelling_bee_contest_backend.impl.RoundStudentImpl;

import java.util.List;

public interface RoundStudentService {

    record RoundAssignmentData(
            List<Integer> studentIds,
            List<WordDTO> availableWords
    ) {}

    List<RoundStudentDTO> listRoundsStudentByIdRound(Integer idRound);
    List<RoundStudentDTO> listWordsUsed(Integer idGradeCategory);
    RoundStudentDTO updateRoundStudent(Integer idRoundStudent, RoundStudentDTO roundStudentDTO);
    RoundStudentDTO addRoundStudent(RoundStudentDTO roundStudentDTO);
    RoundAssignmentData validateAndPrepareAssignment(Integer idGrade, Integer idGradeCategory);
    List<RoundStudentDTO> createRoundStudent(Round idRound, RoundStudentImpl.RoundAssignmentData assignmentData);
}
