package com.project.sys_spelling_bee_contest_backend.impl;

import com.project.sys_spelling_bee_contest_backend.DTO.EventDTO;
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
    public EventDTO listEvent(){
        return eventRepository.findEventByStatusIsTrue()
                .map(eventMapper::eventToDTO)
                .orElseThrow(() -> new RuntimeException("There isn't any event active"));
    }
}
