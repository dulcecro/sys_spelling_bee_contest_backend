package com.project.sys_spelling_bee_contest_backend.model;

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

    private String category;
    private boolean status;

    @OneToMany(mappedBy = "idCategoryDetalle", cascade = CascadeType.ALL)
    private List<GradeCategory> categoriesDetalle;
}
