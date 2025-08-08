package com.project.sys_spelling_bee_contest_backend.DTO;

import com.project.sys_spelling_bee_contest_backend.model.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GradeDTO {
    private Integer idGrade;
    private String grade;
    private Integer idLevel;
    private String level;
    private boolean status;
}
