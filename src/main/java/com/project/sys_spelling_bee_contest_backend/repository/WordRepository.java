package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findAllByIdGradeCategory_IdGradeCategory (Integer idGradeCategory);
    Optional<Word> findWordByNumberAndIdGradeCategory_IdGradeCategory(Integer idNumber, Integer idGradeCategory);
}
