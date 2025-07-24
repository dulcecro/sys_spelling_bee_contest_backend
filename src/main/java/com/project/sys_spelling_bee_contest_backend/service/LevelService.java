package com.project.sys_spelling_bee_contest_backend.service;

import com.project.sys_spelling_bee_contest_backend.model.Level;
import com.project.sys_spelling_bee_contest_backend.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    @Autowired
    private LevelRepository levelRepository;

    public List<Level> listLevels() {
        return levelRepository.findAll();
    }
}
