package com.project.sys_spelling_bee_contest_backend.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_student")
    private int idStudent;

    @Column(name = "last_name")
    private String lastName;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_grade", nullable = false)
    private Grade idGrade;
}
