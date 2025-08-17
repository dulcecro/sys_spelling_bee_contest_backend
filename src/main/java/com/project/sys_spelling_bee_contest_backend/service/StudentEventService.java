package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentEventDTO;

import java.util.List;

public interface StudentEventService {
    List<StudentEventDTO> listStudents(Integer idGrade);
}
