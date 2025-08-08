package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.CriterionDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.CriterionMapper;
import com.project.sys_spelling_bee_contest_backend.model.Criterion;
import com.project.sys_spelling_bee_contest_backend.repository.CriterionRepository;
import com.project.sys_spelling_bee_contest_backend.service.CriterionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriterionImpl implements CriterionService {
    private final CriterionRepository criterionRepository;
    private final CriterionMapper criterionMapper;

    @Override
    public List<CriterionDTO> listCriterion(){
        List<Criterion> criterion = criterionRepository.findAll();
        if(criterion.isEmpty()){
            throw new RuntimeException("The list of criterion is empty");
        }
        return criterion.stream().map(criterionMapper::criterionToDTO).toList();
    }
}
