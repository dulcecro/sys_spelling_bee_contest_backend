package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.RoundMapper;
import com.project.sys_spelling_bee_contest_backend.model.Round;
import com.project.sys_spelling_bee_contest_backend.repository.RoundRepository;
import com.project.sys_spelling_bee_contest_backend.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundImpl implements RoundService {
    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;

    @Override
    public List<RoundDTO> listRoundsByGrades(){
        List<Round> rounds = roundRepository.findAll();
        if(rounds.isEmpty()){
            throw new RuntimeException("The list of rounds is empty");
        };
        return rounds.stream().map(roundMapper::roundToDTO).toList();
    }
}
