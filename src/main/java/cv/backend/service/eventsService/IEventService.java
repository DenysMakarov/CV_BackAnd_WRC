package cv.backend.service.eventsService;

import cv.backend.dto.events.EventDto;
import cv.backend.dto.events.EventParamDto;
import cv.backend.model.Event;

import java.util.List;

public interface IEventService {
    EventDto addEvent(Event event);
    EventDto findEvent(EventParamDto event);
    List<EventDto> findAll();
}
