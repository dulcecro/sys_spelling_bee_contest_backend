package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    @Mappings({
            @Mapping(source = "idLevel.levelName", target = "levelName"),
            @Mapping(source = "idLevel.idLevel", target = "idLevel")
    })

    GradeDTO gradeToDTO(Grade grade);
}
