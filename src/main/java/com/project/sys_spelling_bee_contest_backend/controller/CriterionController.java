package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.CriterionDTO;
import com.project.sys_spelling_bee_contest_backend.service.CriterionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/criterion")
@RequiredArgsConstructor
public class CriterionController {
    private final CriterionService criterionService;

    @GetMapping()
    public ResponseEntity<List<CriterionDTO>> listCriterion(){
        return ResponseEntity.ok(criterionService.listCriterion());
    }
}
