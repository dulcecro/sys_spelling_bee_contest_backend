package com.project.sys_spelling_bee_contest_backend.repository;

import com.project.sys_spelling_bee_contest_backend.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Integer> {

}
