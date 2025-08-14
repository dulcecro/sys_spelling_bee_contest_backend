package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.RoundMapper;
import com.project.sys_spelling_bee_contest_backend.entity.Round;
import com.project.sys_spelling_bee_contest_backend.entity.Word;
import com.project.sys_spelling_bee_contest_backend.repository.RoundRepository;
import com.project.sys_spelling_bee_contest_backend.repository.WordRepository;
import com.project.sys_spelling_bee_contest_backend.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundImpl implements RoundService {
    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;
    private final WordRepository wordRepository;

    @Override
    public List<RoundDTO> listRoundsByNumberRoundAndGrades(Integer numberRound, Integer idGrade) {
        List<Round> rounds = roundRepository.findAllByNumberRoundAndIdStudentEventRound_IdGradeDetail_IdGradeOrderByIdStudentEventRound_IdStudentDetail_PaternalSurnameAscIdStudentEventRound_IdStudentDetail_MaternalSurnameAsc(numberRound, idGrade);
        if(rounds.isEmpty()){
            throw new RuntimeException("The list of rounds is empty");
        };
        return rounds.stream().map(roundMapper::roundToDTO).toList();
    }

    @Override
    public RoundDTO updateRound(Integer idRound, RoundDTO roundDTO){
        Round rounds = roundRepository.findById(idRound).orElseThrow(()-> new RuntimeException("The round with ID" + idRound + " does not exist"));
        if(roundDTO.getCriterionOne() != null) rounds.setCriterionOne(roundDTO.getCriterionOne());
        if(roundDTO.getCriterionTwo() != null) rounds.setCriterionTwo(roundDTO.getCriterionTwo());
        if(roundDTO.getCriterionThree() != null) rounds.setCriterionThree(roundDTO.getCriterionThree());
        if(roundDTO.getCriterionFour() != null) rounds.setCriterionFour(roundDTO.getCriterionFour());
        if(roundDTO.getCriterionFive() != null) rounds.setCriterionFive(roundDTO.getCriterionFive());
        if(roundDTO.getPosition() != null) rounds.setPosition(roundDTO.getPosition());
        if(roundDTO.getClose() != null) rounds.setClose(roundDTO.getClose());
        if(roundDTO.getIdWordRound() != null) {
            Word word = wordRepository.findById(roundDTO.getIdWordRound())
                    .orElseThrow(() -> new RuntimeException("Word no encontrada"));
            rounds.setIdWordRound(word);
        }
        return roundMapper.roundToDTO(roundRepository.save(rounds));
    }

    @Override
    public RoundDTO addRound(RoundDTO roundDTO){
        Round round = roundMapper.dtoToRound(roundDTO);
        if (round.getIdWordRound() != null && round.getIdWordRound().getIdWord() == null) {
            round.setIdWordRound(null);
        }
        return roundMapper.roundToDTO(roundRepository.save(round));
    }
}
