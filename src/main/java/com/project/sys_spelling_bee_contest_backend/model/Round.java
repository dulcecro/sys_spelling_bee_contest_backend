package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "round", schema = "sbee")
@Getter
@Setter
@NoArgsConstructor
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_round")
    private Integer idRound;

    @Column(name = "number_round")
    private Integer numberRound;

    @ManyToOne
    @JoinColumn(name = "id_student_event", nullable = false)
    private StudentEvent idStudentEventRound;

    @ManyToOne
    @JoinColumn(name = "id_word", nullable = false)
    private Word idWordRound;

    @Column(name = "criterion_one")
    private Integer criterionOne;

    @Column(name = "criterion_two")
    private Integer criterionTwo;

    @Column(name = "criterion_three")
    private Integer criterionThree;

    @Column(name = "criterion_four")
    private Integer criterionFour;

    @Column(name = "criterion_five")
    private Integer criterionFive;

    private Integer position;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean close = false;
}
