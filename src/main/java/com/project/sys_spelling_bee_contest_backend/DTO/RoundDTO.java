package com.project.sys_spelling_bee_contest_backend.DTO;

import com.project.sys_spelling_bee_contest_backend.model.StudentEvent;
import com.project.sys_spelling_bee_contest_backend.model.Word;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoundDTO {
    private Integer idRound;
    private Integer numberRound;
    private StudentEvent idStudentEventRound;
    private Word idWordRound;
    private Integer criterionOne;
    private Integer criterionTwo;
    private Integer criterionThree;
    private Integer criterionFour;
    private Integer criterionFive;
    private Integer position;
    private boolean close;
}
