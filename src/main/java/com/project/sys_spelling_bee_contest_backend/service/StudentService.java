package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> listStudents();
}
