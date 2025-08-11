package com.project.sys_spelling_bee_contest_backend.mapper;

import com.project.sys_spelling_bee_contest_backend.DTO.StudentDTO;
import com.project.sys_spelling_bee_contest_backend.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mappings({
            @Mapping(source = "idGrade.idGrade", target = "idGrade"),
            @Mapping(source = "idGrade.gradeName", target = "grade"),
            @Mapping(source = "idGrade.idLevel.idLevel", target = "idLevel"),
            @Mapping(source = "idGrade.idLevel.levelName", target = "level"),
    })
    StudentDTO studentToDTO(Student student);
}
