package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "word", schema = "sbee")
@Getter
@Setter
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_word")
    private Integer idWord;

    @ManyToOne
    @JoinColumn(name = "id_grade_category", nullable = false)
    private GradeCategory idGradeCategory;

    @Column(name = "id_number")
    private Integer idNumber;

    private String word;
    private String pronunciation;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean used = false;
}
