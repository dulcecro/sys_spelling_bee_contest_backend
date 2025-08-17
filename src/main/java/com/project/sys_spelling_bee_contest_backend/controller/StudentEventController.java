package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentEventDTO;
import com.project.sys_spelling_bee_contest_backend.service.StudentEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee/studenEvent")
@RequiredArgsConstructor
public class StudentEventController {
    private final StudentEventService studentEventService;

    @GetMapping("/{idGrade}")
    private ResponseEntity<List<StudentEventDTO>> listStudents(@PathVariable Integer idGrade){
        return ResponseEntity.ok(studentEventService.listStudents(idGrade));
    }
}
