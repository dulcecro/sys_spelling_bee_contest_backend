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
    private Integer idStudentEventRound;
    private String paternalSurname;
    private String maternalSurname;
    private String nameStudent;
    private Integer idWordRound;
    private String word;
    private Integer criterionOne;
    private Integer criterionTwo;
    private Integer criterionThree;
    private Integer criterionFour;
    private Integer criterionFive;
    private Integer position;
    private Boolean close;
}
