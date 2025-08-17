package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.entity.Event;
import com.project.sys_spelling_bee_contest_backend.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbee/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping()
    public ResponseEntity<Event> eventActive(){
        return ResponseEntity.ok(eventService.eventActive());
    }
}
