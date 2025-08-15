package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;

import java.util.List;

public interface RoundStudentService {
    List<RoundStudentDTO> listRoundsByNumberRoundAndGrades(Integer idRound);
    RoundStudentDTO updateRound(Integer idRoundStudent, RoundStudentDTO roundStudentDTO);
    RoundStudentDTO addRound(RoundStudentDTO roundStudentDTO);
}
