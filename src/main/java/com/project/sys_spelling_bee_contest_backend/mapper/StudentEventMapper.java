package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentEventDTO;
import com.project.sys_spelling_bee_contest_backend.entity.StudentEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentEventMapper {
    @Mappings({
            @Mapping(source = "idStudentDetail.idStudent", target = "idStudent"),
            @Mapping(source = "idStudentDetail.paternalSurname", target = "paternalSurname"),
            @Mapping(source = "idStudentDetail.maternalSurname", target = "maternalSurname"),
            @Mapping(source = "idStudentDetail.name", target = "name"),
            @Mapping(source = "idGradeDetail.idGrade", target = "idGrade"),
            @Mapping(source = "idGradeDetail.gradeName", target = "grade"),
            @Mapping(source = "idEventDetail.idEvent", target = "idEvent")
    })
    StudentEventDTO studentEventToDTO(StudentEvent studentEvent);
}
