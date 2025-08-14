package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.WordDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Word;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WordMapper {
    @Mapping(source = "idGradeCategory.idGradeCategory", target = "idGradeCategory")
    WordDTO wordToDTO(Word word);
}
