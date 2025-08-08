package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "criterion", schema = "sbee")
@Getter
@Setter
@NoArgsConstructor
public class Criterion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_criterion")
    private Integer idCriterion;

    private String criterion;
    private Integer score;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean status = true;
}
