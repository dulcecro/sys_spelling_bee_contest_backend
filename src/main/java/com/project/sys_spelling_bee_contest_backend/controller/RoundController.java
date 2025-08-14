package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sbee/round")
@RequiredArgsConstructor
public class RoundController {
    private final RoundService roundService;

    @GetMapping("/{numberRound}/{idGrade}")
    public ResponseEntity<List<RoundDTO>> listRoundsByNumberRoundAndGrades(@PathVariable Integer numberRound, @PathVariable Integer idGrade) {
        return ResponseEntity.ok(roundService.listRoundsByNumberRoundAndGrades(numberRound, idGrade));
    }

    @PatchMapping("/{idRound}")
    public ResponseEntity<RoundDTO> updateRound(@PathVariable Integer idRound, @RequestBody RoundDTO roundDTO){
        return ResponseEntity.ok(roundService.updateRound(idRound, roundDTO));
    }

    @PostMapping()
    public ResponseEntity<RoundDTO> addRound(@RequestBody RoundDTO roundDTO){
        return ResponseEntity.ok(roundService.addRound(roundDTO));
    }
}
