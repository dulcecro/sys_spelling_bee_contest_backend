package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentEventDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Category;
import com.project.sys_spelling_bee_contest_backend.entity.StudentEvent;
import com.project.sys_spelling_bee_contest_backend.mapper.StudentEventMapper;
import com.project.sys_spelling_bee_contest_backend.repository.StudentEventRepository;
import com.project.sys_spelling_bee_contest_backend.service.StudentEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentEventImpl implements StudentEventService {
    private final StudentEventRepository studentEventRepository;
    private final StudentEventMapper studentEventMapper;

    @Override
    public List<StudentEventDTO> listStudents(Integer idGrade){
        List<StudentEvent> studentEvents = studentEventRepository.findStudentEventByIdGradeDetail_IdGrade(idGrade);
        if(studentEvents.isEmpty()){
            throw new RuntimeException("The list of studentEvents is empty");
        }
        return studentEvents.stream().map(studentEventMapper::studentEventToDTO).toList();
    }
}
