package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.CriterionDTO;
import com.project.sys_spelling_bee_contest_backend.model.Criterion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriterionMapper {
    CriterionDTO criterionToDTO(Criterion criterion);
}
