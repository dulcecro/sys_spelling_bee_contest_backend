package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoundDTO {
    private Integer idRound;
    private Integer idGrade;
    private String gradeRound;
    private String levelGrade;
    private Integer numberRound;
    private Boolean status;
}
