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

    @GetMapping("/word_number/{idNumber}/{idGradeCategory}")
    public ResponseEntity<WordDTO> findWordByIdNumberAndIdGradeCategory(@PathVariable Integer idNumber, @PathVariable Integer idGradeCategory){
        return ResponseEntity.ok(wordService.findWordByIdNumberAndIdGradeCategory(idNumber, idGradeCategory));
    }

    @PutMapping("/{idNumber}/{idGradeCategory}")
    public ResponseEntity<WordDTO> updateActive(@PathVariable Integer idNumber, @PathVariable Integer idGradeCategory, @RequestBody WordDTO wordDTO){
        return ResponseEntity.ok(wordService.updateActive(idNumber, idGradeCategory, wordDTO));
    }
}
