package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.LevelDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.LevelMapper;
import com.project.sys_spelling_bee_contest_backend.model.Level;
import com.project.sys_spelling_bee_contest_backend.repository.LevelRepository;
import com.project.sys_spelling_bee_contest_backend.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelImpl implements LevelService {
    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    @Override
    public List<LevelDTO> listLevels() {
        List<Level> levels = levelRepository.findAll();
        if(levels.isEmpty()){
            throw new RuntimeException("No levels found");
        }
        return levels.stream().map(levelMapper::levelToDTO).toList();
    }
}
