package com.project.sys_spelling_bee_contest_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_event", schema = "sbee")
@Getter
@Setter
@NoArgsConstructor
public class StudentEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student_event")
    private Integer idStudentEvent;

    @ManyToOne
    @JoinColumn(name = "id_event", nullable = false)
    private Event idEventDetail;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student idStudentDetail;

    @ManyToOne
    @JoinColumn(name = "id_grade", nullable = false)
    private Grade idGradeDetail;
}
