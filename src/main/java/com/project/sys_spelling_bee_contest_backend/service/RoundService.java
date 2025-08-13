package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.model.Round;

import java.util.List;

public interface RoundService {
    List<RoundDTO> listRoundsByNumberRoundAndGrades(Integer numberRound, Integer idGrade);
    RoundDTO updateScoreAndPosition(Integer idRound, RoundDTO roundDTO);
    RoundDTO addRound(RoundDTO roundDTO);
}
