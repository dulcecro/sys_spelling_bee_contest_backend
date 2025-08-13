package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "event", schema = "sbee")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Integer idEvent;

    @Column(name = "event_name")
    private String eventName;

    private LocalDate date;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status = true;
}
