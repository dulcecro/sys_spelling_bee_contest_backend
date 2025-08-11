package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WordDTO {
    private Integer idWord;
    private Integer idGradeCategory;
    private Integer number;
    private String word;
    private String pronunciation;
}
