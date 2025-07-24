package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.model.Grade;
import com.project.sys_spelling_bee_contest_backend.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> listGrades(){
        return gradeRepository.findAll();
    };
}
