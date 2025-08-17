package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoundDTO {
    private Integer idRound;
    private Integer numberRound;
    private Integer idGrade;
    private String gradeRound;
    private String levelGrade;
    private Integer idCategory;
    private String categoryRound;
    private Boolean close;
}
