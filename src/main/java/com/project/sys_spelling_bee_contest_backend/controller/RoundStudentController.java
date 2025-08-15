package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;
import com.project.sys_spelling_bee_contest_backend.service.RoundStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sbee/round")
@RequiredArgsConstructor
public class RoundStudentController {
    private final RoundStudentService roundStudentService;

    @GetMapping("/{numberRound}/{idGrade}")
    public ResponseEntity<List<RoundStudentDTO>> listRoundsByNumberRoundAndGrades(@PathVariable Integer numberRound, @PathVariable Integer idGrade) {
        return ResponseEntity.ok(roundStudentService.listRoundsByNumberRoundAndGrades(numberRound, idGrade));
    }

    @PatchMapping("/{idRound}")
    public ResponseEntity<RoundStudentDTO> updateRound(@PathVariable Integer idRound, @RequestBody RoundStudentDTO roundStudentDTO){
        return ResponseEntity.ok(roundStudentService.updateRound(idRound, roundStudentDTO));
    }

    @PostMapping()
    public ResponseEntity<RoundStudentDTO> addRound(@RequestBody RoundStudentDTO roundStudentDTO){
        return ResponseEntity.ok(roundStudentService.addRound(roundStudentDTO));
    }
}
