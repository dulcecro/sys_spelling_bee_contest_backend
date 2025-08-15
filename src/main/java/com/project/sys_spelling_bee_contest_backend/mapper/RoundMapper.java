package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Round;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoundMapper {
    @Mappings({
            @Mapping(source = "idGradeRound.idGrade", target = "idGrade"),
            @Mapping(source = "idGradeRound.gradeName", target = "gradeRound"),
            @Mapping(source = "idGradeRound.idLevel.levelName", target = "levelGrade")
    })
    RoundDTO roundToDTO(Round round);
}
