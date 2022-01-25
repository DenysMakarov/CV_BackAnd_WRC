package cv.backend.dao;

import cv.backend.model.Event;
import cv.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findEventByTextBottomAndPrice(String title, String price);
}
