package com.project.sys_spelling_bee_contest_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "level", schema = "general")
@Setter
@Getter
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_level")
    private Integer idLevel;

    @Column(name = "level_name")
    private String levelName;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status = true;

}
