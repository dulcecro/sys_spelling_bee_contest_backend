package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "grade", schema = "general")
@Setter
@Getter
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Integer idGrade;

    @Column(name = "grade_name")
    private String gradeName;

    @ManyToOne
    @JoinColumn(name = "id_level", nullable = false)
    private Level idLevel;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status = true;

    private Integer priority;
}
