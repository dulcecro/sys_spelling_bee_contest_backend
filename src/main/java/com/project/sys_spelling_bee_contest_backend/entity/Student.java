package com.project.sys_spelling_bee_contest_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student", schema = "school")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;

    @Column(name = "paternal_surname")
    private String paternalSurname;

    @Column(name = "maternal_surname")
    private String maternalSurname;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_grade", nullable = false)
    private Grade idGrade;
}
