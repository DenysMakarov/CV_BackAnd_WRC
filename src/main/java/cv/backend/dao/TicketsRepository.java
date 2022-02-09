package cv.backend.dao;

import cv.backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Ticket, Long> {
    void deleteTicketById(Long id);
    Ticket findTicketById(Long id);
}
