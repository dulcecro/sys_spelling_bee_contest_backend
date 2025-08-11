package com.project.sys_spelling_bee_contest_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category", schema = "general")
@Setter
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "category_name")
    private String categoryName;

    private Integer difficulty;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean status = true;
}
