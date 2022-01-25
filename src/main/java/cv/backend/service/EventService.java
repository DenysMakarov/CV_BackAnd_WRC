package cv.backend.service;

import cv.backend.dto.EventDto;
import cv.backend.model.Event;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService{

    @Override
    public EventDto addEvent(Event event) {
        return null;
    }
}
