package com.project.sys_spelling_bee_contest_backend.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EventDTO {
    private Integer idEvent;
    private String eventName;
    private LocalDate date;
    private Boolean status;
}
