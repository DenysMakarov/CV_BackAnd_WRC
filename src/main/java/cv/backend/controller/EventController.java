package cv.backend.controller;

import cv.backend.dto.EventDto;
import cv.backend.dto.EventParamDto;
import cv.backend.model.Event;
import cv.backend.model.User;
import cv.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EventController {
    EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events/event")
    public EventDto addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @GetMapping("/events/event")
    public EventDto getEvent(@RequestBody EventParamDto event) {
        return eventService.findEvent(event);
    }

}
