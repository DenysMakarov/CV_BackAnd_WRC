package cv.backend.service;

import cv.backend.dto.EventDto;
import cv.backend.dto.EventParamDto;
import cv.backend.model.Event;

public interface IEventService {
    EventDto addEvent(Event event);
    EventDto findEvent(EventParamDto event);
}
