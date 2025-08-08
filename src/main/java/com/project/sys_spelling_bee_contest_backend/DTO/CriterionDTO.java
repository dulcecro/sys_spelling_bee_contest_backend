package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CriterionDTO {
    private Integer idCriterion;
    private String criterion;
    private Integer score;
    private boolean status;
}
