package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.GradeCategoryDTO;
import com.project.sys_spelling_bee_contest_backend.model.GradeCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GradeCategoryMapper {
    @Mappings({
            @Mapping(source = "idGradeDetalle.grade", target = "grade"),
            @Mapping(source = "idGradeDetalle.idLevel.level", target = "level")
    })
    GradeCategoryDTO gradeCategoryToDTO(GradeCategory gradeCategory);
}
