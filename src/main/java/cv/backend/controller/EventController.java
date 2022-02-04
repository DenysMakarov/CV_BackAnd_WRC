package cv.backend.controller;

import cv.backend.dto.events.EventDto;
import cv.backend.dto.events.EventParamDto;
import cv.backend.model.Event;
import cv.backend.service.eventsService.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/events/events")
    public List<EventDto> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/event/{id}")
    public EventDto getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }
}
