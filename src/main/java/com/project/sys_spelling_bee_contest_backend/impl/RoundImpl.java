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
    public List<RoundDTO> listRoundsByNumberRoundAndGrades(Integer numberRound, Integer idGrade) {
        List<Round> rounds = roundRepository.findAllByNumberRoundAndIdStudentEventRound_IdGradeDetail_IdGradeOrderByIdStudentEventRound_IdStudentDetail_PaternalSurnameAscIdStudentEventRound_IdStudentDetail_MaternalSurnameAsc(numberRound, idGrade);
        if(rounds.isEmpty()){
            throw new RuntimeException("The list of rounds is empty");
        };
        return rounds.stream().map(roundMapper::roundToDTO).toList();
    }

    @Override
    public RoundDTO updateScoreAndPosition(Integer idRound, RoundDTO roundDTO){
        Round rounds = roundRepository.findById(idRound).orElseThrow(()-> new RuntimeException("The round with ID" + idRound + " does not exist"));
        rounds.setCriterionOne(roundDTO.getCriterionOne());
        rounds.setCriterionTwo(roundDTO.getCriterionTwo());
        rounds.setCriterionThree(roundDTO.getCriterionThree());
        rounds.setCriterionFour(roundDTO.getCriterionFour());
        rounds.setCriterionFive(roundDTO.getCriterionFive());
        rounds.setPosition(roundDTO.getPosition());
        return roundMapper.roundToDTO(roundRepository.save(rounds));
    }
}
