package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.WordDTO;
import com.project.sys_spelling_bee_contest_backend.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sbee/word")
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

    @GetMapping()
    public ResponseEntity<List<WordDTO>> listWords(){
        return ResponseEntity.ok(wordService.listWords());
    }

    @GetMapping("/{idGradeCategory}")
    public ResponseEntity<List<WordDTO>> findWordsByIdGradeCategory(@PathVariable Integer idGradeCategory){
        return ResponseEntity.ok(wordService.findWordsByIdGradeCategory(idGradeCategory));
    }

    @GetMapping("/{number}/{idGradeCategory}")
    public ResponseEntity<WordDTO> findWordByNumberAndIdGradeCategory(@PathVariable Integer number, @PathVariable Integer idGradeCategory){
        return ResponseEntity.ok(wordService.findWordByNumberAndIdGradeCategory(number, idGradeCategory));
    }
}
