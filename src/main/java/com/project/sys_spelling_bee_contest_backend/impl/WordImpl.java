package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.WordDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.WordMapper;
import com.project.sys_spelling_bee_contest_backend.model.Word;
import com.project.sys_spelling_bee_contest_backend.repository.WordRepository;
import com.project.sys_spelling_bee_contest_backend.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordImpl implements WordService {
    private final WordRepository wordRepository;
    private final WordMapper wordMapper;

    @Override
    public List<WordDTO> listWords() {
        List<Word> words = wordRepository.findAll();
        if(words.isEmpty()){
            throw new RuntimeException("The list of words is empty");
        }
        return words.stream().map(wordMapper::wordToDTO).toList();
    }

    @Override
    public List<WordDTO> findWordsByIdGradeCategory (Integer idGradeCategory) {
        List<Word> words = wordRepository.findAllByIdGradeCategory_IdGradeCategory(idGradeCategory);
        if(words.isEmpty()){
            throw new RuntimeException("Grade category not found with ID: " + idGradeCategory);
        }
        return words.stream().map(wordMapper::wordToDTO).toList();
    }
}
