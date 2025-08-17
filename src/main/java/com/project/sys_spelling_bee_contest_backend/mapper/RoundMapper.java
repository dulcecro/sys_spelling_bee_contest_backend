package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Round;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoundMapper {
    @Mappings({
            @Mapping(source = "idGradeCategoryRound.idGradeDetalle.idGrade", target = "idGrade"),
            @Mapping(source = "idGradeCategoryRound.idGradeDetalle.gradeName", target = "gradeRound"),
            @Mapping(source = "idGradeCategoryRound.idGradeDetalle.idLevel.levelName", target = "levelGrade"),
            @Mapping(source = "idGradeCategoryRound.idCategoryDetalle.idCategory", target = "idCategory"),
            @Mapping(source = "idGradeCategoryRound.idCategoryDetalle.categoryName", target = "categoryRound")
    })
    RoundDTO roundToDTO(Round round);
}
