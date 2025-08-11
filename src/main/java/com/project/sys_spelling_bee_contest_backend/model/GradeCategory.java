package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "grade_category", schema = "general")
public class GradeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade_category")
    private Integer idGradeCategory;

    @ManyToOne
    @JoinColumn(name = "id_grade", nullable = false)
    private Grade idGradeDetalle;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category idCategoryDetalle;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean status = true;
}
