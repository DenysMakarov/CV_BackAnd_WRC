package cv.backend.dto.tickets;

import com.fasterxml.jackson.annotation.JsonFormat;
import cv.backend.model.Event;
import cv.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TicketForUserDto {
    String id;
    String title;
    String place;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date = LocalDate.now();
    Double price;
}
