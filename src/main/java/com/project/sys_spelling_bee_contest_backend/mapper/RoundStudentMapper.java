package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.RoundStudentDTO;
import com.project.sys_spelling_bee_contest_backend.entity.RoundStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoundStudentMapper {
    @Mappings({
            @Mapping(source = "idStudentEventRound.idStudentEvent", target = "idStudentEventRound"),
            @Mapping(source = "idStudentEventRound.idStudentDetail.paternalSurname", target = "paternalSurname"),
            @Mapping(source = "idStudentEventRound.idStudentDetail.maternalSurname", target = "maternalSurname"),
            @Mapping(source = "idStudentEventRound.idStudentDetail.name", target = "nameStudent"),
            @Mapping(source = "idWordRound.idWord", target = "idWordRound"),
            @Mapping(source = "idWordRound.word", target = "word")
    })
    RoundStudentDTO roundStudentToDTO(RoundStudent roundStudent);

    @Mappings({
            @Mapping(source = "idStudentEventRound", target = "idStudentEventRound.idStudentEvent"),
            @Mapping(source = "idWordRound", target = "idWordRound.idWord")
    })
    RoundStudent dtoToRoundStudent(RoundStudentDTO roundStudentDTO);
}
