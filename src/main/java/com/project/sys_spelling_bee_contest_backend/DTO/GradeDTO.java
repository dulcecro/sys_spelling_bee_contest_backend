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
    private String gradeName;
    private Integer idLevel;
    private String levelName;
    private Boolean status;
    private Integer priority;
}
