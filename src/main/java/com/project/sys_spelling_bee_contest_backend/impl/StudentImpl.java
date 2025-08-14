package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.StudentMapper;
import com.project.sys_spelling_bee_contest_backend.entity.Student;
import com.project.sys_spelling_bee_contest_backend.repository.StudentRepository;
import com.project.sys_spelling_bee_contest_backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDTO> listStudents() {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            throw new RuntimeException("The list of is empty");
        }
        return students.stream().map(studentMapper::studentToDTO).toList();
    }
}
