package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.EventDTO;
import com.project.sys_spelling_bee_contest_backend.entity.Event;
import com.project.sys_spelling_bee_contest_backend.mapper.EventMapper;
import com.project.sys_spelling_bee_contest_backend.repository.EventRepository;
import com.project.sys_spelling_bee_contest_backend.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public Event eventActive(){
        return eventRepository.findEventByStatusIsTrue()
                .orElseThrow(() -> new RuntimeException("There isn't any event active"));
    }
}
