package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.model.Word;
import com.project.sys_spelling_bee_contest_backend.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public List<Word> listWords() {
        return wordRepository.findAll();
    }
}
