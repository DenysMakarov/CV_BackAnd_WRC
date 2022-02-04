package cv.backend.dao;

import cv.backend.model.Event;
import cv.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findEventByTitleAndPrice(String title, Double price);

    Event findEventByTitleAndDate(String title, LocalDate date);

    List<Event> findAll();

    Event findEventById(Long id);
}
