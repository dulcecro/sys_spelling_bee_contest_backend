package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;
import com.project.sys_spelling_bee_contest_backend.service.RoundStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sbee/round_student")
@RequiredArgsConstructor
public class RoundStudentController {
    private final RoundStudentService roundStudentService;

    @GetMapping("/{idRound}")
    public ResponseEntity<List<RoundStudentDTO>> listRoundsByNumberRoundAndGrades(@PathVariable Integer idRound) {
        return ResponseEntity.ok(roundStudentService.listRoundsByNumberRoundAndGrades(idRound));
    }

    @PatchMapping("/{idRoundStudent}")
    public ResponseEntity<RoundStudentDTO> updateRound(@PathVariable Integer idRoundStudent, @RequestBody RoundStudentDTO roundStudentDTO){
        return ResponseEntity.ok(roundStudentService.updateRoundStudent(idRoundStudent, roundStudentDTO));
    }

    @PostMapping()
    public ResponseEntity<RoundStudentDTO> addRound(@RequestBody RoundStudentDTO roundStudentDTO){
        return ResponseEntity.ok(roundStudentService.addRoundStudent(roundStudentDTO));
    }
}
