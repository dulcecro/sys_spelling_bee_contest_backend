package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.EventDTO;
import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Event;
import com.project.sys_spelling_bee_contest_backend.entity.GradeCategory;
import com.project.sys_spelling_bee_contest_backend.entity.Round;
import com.project.sys_spelling_bee_contest_backend.mapper.RoundMapper;
import com.project.sys_spelling_bee_contest_backend.repository.RoundRepository;
import com.project.sys_spelling_bee_contest_backend.service.EventService;
import com.project.sys_spelling_bee_contest_backend.service.GradeCategoryService;
import com.project.sys_spelling_bee_contest_backend.service.RoundService;
import com.project.sys_spelling_bee_contest_backend.service.RoundStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundImpl implements RoundService {
    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;
    private final GradeCategoryService gradeCategoryService;
    private final EventService eventService;
    private final RoundStudentService roundStudentService;

    @Override
    public List<RoundDTO> listRounds(Integer idGrade){
        List<Round> rounds = roundRepository.findByIdGradeCategoryRound_IdGradeDetalle_IdGrade(idGrade);
        return rounds.stream().map(roundMapper::roundToDTO).toList();
    }

    @Override
    public RoundDTO updateRound(Integer idRound, RoundDTO roundDTO){
        Round round = roundRepository.findById(idRound).orElseThrow(()-> new RuntimeException("The round with ID: "+ idRound + " does not exist"));
        if(roundDTO.getClose() != null) round.setClose(roundDTO.getClose());
        return roundMapper.roundToDTO(roundRepository.save(round));
    }

    @Override
    @Transactional
    public RoundDTO createRound(Integer idGrade, Integer idCategory){
        // Get idGradeCategory
        GradeCategory gradeCategory = gradeCategoryService.getIdGradeCategory(idGrade, idCategory);
        int idGradeCategory = gradeCategory.getIdGradeCategory();

        RoundStudentService.RoundAssignmentData assignmentData = roundStudentService.validateAndPrepareAssignment(idGrade, idGradeCategory);

        // List rounds by idGrade
        List<RoundDTO> listRounds = listRounds(idGrade);

        // Get nextNumberRound
        Integer nextNumberRound = listRounds.stream()
                .map(RoundDTO::getNumberRound)
                .max(Integer::compareTo)
                .map(max -> max + 1)
                .orElse(1);

        // Get idEvent of event active
        Event eventActive = eventService.eventActive();

        // Create new round
        Round newRound = new Round();
        newRound.setIdEventRound(eventActive);
        newRound.setIdGradeCategoryRound(gradeCategory);
        newRound.setNumberRound(nextNumberRound);

        newRound = roundRepository.save(newRound);
        roundStudentService.createRoundStudent(newRound, assignmentData);

        return roundMapper.roundToDTO(newRound);
    }
}
