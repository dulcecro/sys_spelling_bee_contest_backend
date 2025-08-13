package com.project.sys_spelling_bee_contest_backend.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private Integer idCategory;
    private String categoryName;
    private Integer difficulty;
    private Boolean status;
}
