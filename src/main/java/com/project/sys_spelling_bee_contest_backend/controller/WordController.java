package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.model.Word;
import com.project.sys_spelling_bee_contest_backend.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping()
    public List<Word> listWords(){
        return wordService.listWords();
    }
}
