package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundDTO;
import com.project.sys_spelling_bee_contest_backend.model.Round;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoundMapper {
    RoundDTO roundToDTO(Round round);
}
