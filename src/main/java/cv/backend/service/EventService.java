package cv.backend.service;

import cv.backend.dao.EventRepository;
import cv.backend.dto.EventDto;
import cv.backend.dto.EventParamDto;
import cv.backend.model.Event;
import cv.backend.model.exeptions.EntityConflictException;
import cv.backend.model.exeptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService {
    EventRepository eventRepository;
    ModelMapper modelMapper;

    @Autowired
    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EventDto addEvent(Event event) {
        Event e = eventRepository.findEventByTitleAndDate(event.getTitle(), event.getDate());
        if (e != null) throw new EntityConflictException();
        eventRepository.save(event);
        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public EventDto findEvent(EventParamDto event) {
        Event e = eventRepository.findEventByTitleAndDate(event.getTitle(), event.getDate());
        if (e == null) throw new EntityConflictException();
        return modelMapper.map(e, EventDto.class);
    }
}
