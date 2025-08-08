package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.WordDTO;

import java.util.List;
import java.util.Optional;

public interface WordService {
    List<WordDTO> listWords();
    List<WordDTO> findWordsByIdGradeCategory(Integer idGradeCategory);
    WordDTO findWordByIdNumberAndIdGradeCategory(Integer idNumber, Integer idGradeCategory);
}
