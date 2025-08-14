package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.GradeMapper;
import com.project.sys_spelling_bee_contest_backend.entity.Grade;
import com.project.sys_spelling_bee_contest_backend.repository.GradeRepository;
import com.project.sys_spelling_bee_contest_backend.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;

    @Override
    public List<GradeDTO> listGrades(){
        List<Grade> grade = gradeRepository.findAllByStatusIsTrue();
        if(grade.isEmpty()){
            throw new RuntimeException("The list of grades is empty");
        }

        return grade.stream().map(gradeMapper::gradeToDTO).toList();
    };
}
