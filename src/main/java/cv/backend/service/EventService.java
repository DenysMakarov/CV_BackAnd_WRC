package cv.backend.service;

import cv.backend.dao.EventRepository;
import cv.backend.dto.EventDto;
import cv.backend.model.Event;
import cv.backend.model.exeptions.EntityConflictException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService{
    EventRepository eventRepository;
    ModelMapper modelMapper;

    @Autowired
    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EventDto addEvent(Event event) {
        System.out.println(event.getDate());
//        if(eventRepository.existsById(event.getId())) throw new EntityConflictException();
        Event e = eventRepository.findEventByTextBottomAndPrice(event.getTextBottom(), event.getPrice());
        if (e == null) eventRepository.save(event);
        return modelMapper.map(event, EventDto.class);
    }
}
