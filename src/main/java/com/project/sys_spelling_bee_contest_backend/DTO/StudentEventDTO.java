package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentEventDTO {
    private Integer idStudentEvent;
    private Integer idStudent;
    private String paternalSurname;
    private String maternalSurname;
    private String name;
    private Integer idGrade;
    private String grade;
    private Integer idEvent;
}
