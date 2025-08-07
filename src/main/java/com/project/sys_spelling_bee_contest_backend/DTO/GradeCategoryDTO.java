package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GradeCategoryDTO {
    private int idGradeCategory;
    private String grade;
    private String level;
    private boolean active;
}
