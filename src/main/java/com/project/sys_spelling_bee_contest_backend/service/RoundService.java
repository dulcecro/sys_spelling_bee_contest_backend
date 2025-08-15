package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;

import java.util.List;

public interface RoundService {
    List<RoundDTO> listRounds(Integer idGrade);
}
