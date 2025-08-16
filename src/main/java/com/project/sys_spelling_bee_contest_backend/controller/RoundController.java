package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/round")
@RequiredArgsConstructor
public class RoundController {
    private final RoundService roundService;

    @GetMapping("/{idGrade}")
    public ResponseEntity<List<RoundDTO>> listRounds(Integer idGrade){
        return ResponseEntity.ok(roundService.listRounds(idGrade));
    }

    @PatchMapping("/{idRound}")
    public ResponseEntity<RoundDTO> updateRound(Integer idRound, RoundDTO roundDTO){
        return ResponseEntity.ok(roundService.updateRound(idRound, roundDTO));
    }
}
