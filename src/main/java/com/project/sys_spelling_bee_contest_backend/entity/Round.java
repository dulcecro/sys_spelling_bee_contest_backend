package com.project.sys_spelling_bee_contest_backend.entity;

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

    @ManyToOne()
    @JoinColumn(name = "id_event", nullable = false)
    private Event idEventRound;

    @ManyToOne()
    @JoinColumn(name = "id_grade", nullable = false)
    private Grade idGradeRound;

    @Column(name = "number_round")
    private Integer numberRound;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status = true;
}
