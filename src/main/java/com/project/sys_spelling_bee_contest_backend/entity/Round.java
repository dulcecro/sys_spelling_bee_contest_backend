package com.project.sys_spelling_bee_contest_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "round", schema = "sbee")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
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
    @JoinColumn(name = "id_word")
    private Word idWordRound;

    @Column(name = "criterion_one", columnDefinition = "INTEGER DEFAULT 5")
    private Integer criterionOne = 5;

    @Column(name = "criterion_two", columnDefinition = "INTEGER DEFAULT 5")
    private Integer criterionTwo = 5;

    @Column(name = "criterion_three", columnDefinition = "INTEGER DEFAULT 5")
    private Integer criterionThree = 5;

    @Column(name = "criterion_four", columnDefinition = "INTEGER DEFAULT 5")
    private Integer criterionFour = 5;

    @Column(name = "criterion_five", columnDefinition = "INTEGER DEFAULT 5")
    private Integer criterionFive = 5;

    @Column(name = "position", columnDefinition = "INTEGER DEFAULT 0")
    private Integer position;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean close = false;
}
