package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LevelDTO {
    private Integer idLevel;
    private String levelName;
    private boolean status;
}
