package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;
import com.project.sys_spelling_bee_contest_backend.DTO.StudentEventDTO;
import com.project.sys_spelling_bee_contest_backend.DTO.WordDTO;
import com.project.sys_spelling_bee_contest_backend.entity.*;
import com.project.sys_spelling_bee_contest_backend.mapper.RoundStudentMapper;
import com.project.sys_spelling_bee_contest_backend.repository.RoundRepository;
import com.project.sys_spelling_bee_contest_backend.repository.RoundStudentRepository;
import com.project.sys_spelling_bee_contest_backend.repository.WordRepository;
import com.project.sys_spelling_bee_contest_backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class RoundStudentImpl implements RoundStudentService {
    private final RoundStudentRepository roundStudentRepository;
    private final RoundStudentMapper roundStudentMapper;
    private final WordRepository wordRepository;
    private final StudentEventService studentEventService;
    private final GradeCategoryService gradeCategoryService;
    private final WordService wordService;
    private final RoundRepository roundRepository;

    @Override
    public List<RoundStudentDTO> listRoundsStudentByIdRound(Integer idRound) {
        List<RoundStudent> roundStudents = roundStudentRepository.findAllByIdRound_IdRoundOrderByIdStudentEventRound_IdStudentDetail_PaternalSurnameAscIdStudentEventRound_IdStudentDetail_MaternalSurnameAsc(idRound);
        return roundStudents.stream().map(roundStudentMapper::roundStudentToDTO).toList();
    }

    @Override
    public List<RoundStudentDTO> listWordsUsed(Integer idGradeCategory){
        List<RoundStudent> listWordsUsed = roundStudentRepository.findAllByIdWordRound_IdGradeCategory_idGradeCategory(idGradeCategory);
        return listWordsUsed.stream().map(roundStudentMapper::roundStudentToDTO).toList();
    }

    @Override
    public RoundStudentDTO updateRoundStudent(Integer idRoundStudent, RoundStudentDTO roundStudentDTO){
        RoundStudent rounds = roundStudentRepository.findById(idRoundStudent).orElseThrow(()-> new RuntimeException("The roundStudents with ID" + idRoundStudent + " does not exist"));
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
    public RoundStudentDTO addRoundStudent(RoundStudentDTO roundStudentDTO){
        RoundStudent roundStudent = roundStudentMapper.dtoToRoundStudent(roundStudentDTO);
        if (roundStudent.getIdWordRound() != null && roundStudent.getIdWordRound().getIdWord() == null) {
            roundStudent.setIdWordRound(null);
        }
        return roundStudentMapper.roundStudentToDTO(roundStudentRepository.save(roundStudent));
    }

    @Override
    public RoundAssignmentData validateAndPrepareAssignment(Integer idGrade, Integer idGradeCategory){
        Round previousRound = roundRepository.findTopByIdGradeCategoryRound_IdGradeDetalle_IdGradeOrderByIdRoundDesc(idGrade);

        // Get list of student by idRound
        List<RoundStudentDTO> previousRoundsStudents = previousRound == null
                ? List.of()
                : listRoundsStudentByIdRound(previousRound.getIdRound());

        // Get list of words used by idGradeCategory
        List<RoundStudentDTO> previousWordsUsed = listWordsUsed(idGradeCategory).isEmpty()
                ? List.of()
                : listWordsUsed(idGradeCategory);

        List<Integer> studentsIds;
        Set<Integer> usedWordIds;

        // Validate if the list is empty, call listStudents else previousRoundsStudents
        if (previousRoundsStudents.isEmpty()) {
            studentsIds = studentEventService.listStudents(idGrade).stream().map(StudentEventDTO::getIdStudentEvent).toList();
            usedWordIds = Set.of();
        } else {
            studentsIds = previousRoundsStudents.stream()
                    .filter(criterion -> criterion.getCriterionOne() != 0 &&
                            criterion.getCriterionTwo() != 0 &&
                            criterion.getCriterionThree() != 0 &&
                            criterion.getCriterionFour() != 0 &&
                            criterion.getCriterionFive() != 0).map(RoundStudentDTO::getIdStudentEventRound).toList();
            usedWordIds = previousWordsUsed.stream().map(RoundStudentDTO::getIdWordRound).collect(Collectors.toSet());
        }

        // List of available words not used by idCategory and idGrade
        List<WordDTO> availableWords = new ArrayList<>(wordService.findWordsByIdGradeCategory(idGradeCategory)
                .stream().filter(word -> !usedWordIds.contains(word.getIdWord())).toList());

        if (availableWords.size() < studentsIds.size()) {
            throw new IllegalStateException("There aren't enough available words for all students.");
        }

        return new RoundAssignmentData(studentsIds, availableWords);
    }

    @Override
    public List<RoundStudentDTO> createRoundStudent(Round idRound, RoundAssignmentData assignmentData) {

        List<Integer> studentsIds = assignmentData.studentIds();
        List<WordDTO> availableWords = new ArrayList<>(assignmentData.availableWords());

        // Mix words by total students
        Collections.shuffle(availableWords);
        List<WordDTO> selectWords = availableWords.stream().limit(studentsIds.size()).toList();

        // Assign students with words
        List<RoundStudent> listRoundStudents = IntStream.range(0, studentsIds.size())
                .mapToObj(i -> {
                    RoundStudent roundStudent = new RoundStudent();
                    roundStudent.setIdRound(idRound);
                    StudentEvent studentEvent = new StudentEvent();
                    studentEvent.setIdStudentEvent(studentsIds.get(i));
                    roundStudent.setIdStudentEventRound(studentEvent);
                    Word word = new Word();
                    word.setIdWord(selectWords.get(i).getIdWord());
                    roundStudent.setIdWordRound(word);
                    roundStudent.setActive(i == 0);
                    return roundStudent;
                }).toList();

        return roundStudentMapper.roundStudentListToDTOList(roundStudentRepository.saveAll(listRoundStudents));
    }
}
