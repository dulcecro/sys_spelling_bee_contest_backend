package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/round")
@RequiredArgsConstructor
public class RoundController {
    private final RoundService roundService;

    @GetMapping("/{numberRound}/{idGrade}")
    public List<RoundDTO> listRoundsByNumberRoundAndGrades(@PathVariable Integer numberRound, @PathVariable Integer idGrade) {
        return roundService.listRoundsByNumberRoundAndGrades(numberRound, idGrade);
    }
}
