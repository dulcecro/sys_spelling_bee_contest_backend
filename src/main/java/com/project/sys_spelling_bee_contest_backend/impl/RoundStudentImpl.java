package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;
import com.project.sys_spelling_bee_contest_backend.mapper.RoundStudentMapper;
import com.project.sys_spelling_bee_contest_backend.entity.RoundStudent;
import com.project.sys_spelling_bee_contest_backend.entity.Word;
import com.project.sys_spelling_bee_contest_backend.repository.RoundStudentRepository;
import com.project.sys_spelling_bee_contest_backend.repository.WordRepository;
import com.project.sys_spelling_bee_contest_backend.service.RoundStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundStudentImpl implements RoundStudentService {
    private final RoundStudentRepository roundStudentRepository;
    private final RoundStudentMapper roundStudentMapper;
    private final WordRepository wordRepository;

    @Override
    public List<RoundStudentDTO> listRoundsByNumberRoundAndGrades(Integer numberRound, Integer idGrade) {
        List<RoundStudent> roundStudents = roundStudentRepository.findAllByNumberRoundAndIdStudentEventRound_IdGradeDetail_IdGradeOrderByIdStudentEventRound_IdStudentDetail_PaternalSurnameAscIdStudentEventRound_IdStudentDetail_MaternalSurnameAsc(numberRound, idGrade);
        if(roundStudents.isEmpty()){
            throw new RuntimeException("The list of roundStudents is empty");
        };
        return roundStudents.stream().map(roundStudentMapper::roundStudentToDTO).toList();
    }

    @Override
    public RoundStudentDTO updateRound(Integer idRound, RoundStudentDTO roundStudentDTO){
        RoundStudent rounds = roundStudentRepository.findById(idRound).orElseThrow(()-> new RuntimeException("The round with ID" + idRound + " does not exist"));
        if(roundStudentDTO.getCriterionOne() != null) rounds.setCriterionOne(roundStudentDTO.getCriterionOne());
        if(roundStudentDTO.getCriterionTwo() != null) rounds.setCriterionTwo(roundStudentDTO.getCriterionTwo());
        if(roundStudentDTO.getCriterionThree() != null) rounds.setCriterionThree(roundStudentDTO.getCriterionThree());
        if(roundStudentDTO.getCriterionFour() != null) rounds.setCriterionFour(roundStudentDTO.getCriterionFour());
        if(roundStudentDTO.getCriterionFive() != null) rounds.setCriterionFive(roundStudentDTO.getCriterionFive());
        if(roundStudentDTO.getPosition() != null) rounds.setPosition(roundStudentDTO.getPosition());
        if(roundStudentDTO.getClose() != null) rounds.setClose(roundStudentDTO.getClose());
        if(roundStudentDTO.getIdWordRound() != null) {
            Word word = wordRepository.findById(roundStudentDTO.getIdWordRound())
                    .orElseThrow(() -> new RuntimeException("Word no encontrada"));
            rounds.setIdWordRound(word);
        }
        return roundStudentMapper.roundStudentToDTO(roundStudentRepository.save(rounds));
    }

    @Override
    public RoundStudentDTO addRound(RoundStudentDTO roundStudentDTO){
        RoundStudent roundStudent = roundStudentMapper.dtoToRoundStudent(roundStudentDTO);
        if (roundStudent.getIdWordRound() != null && roundStudent.getIdWordRound().getIdWord() == null) {
            roundStudent.setIdWordRound(null);
        }
        return roundStudentMapper.roundStudentToDTO(roundStudentRepository.save(roundStudent));
    }
}
