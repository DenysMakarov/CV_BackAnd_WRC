package cv.backend.dto.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import cv.backend.dto.tickets.TicketForEventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EventDto {
    String title;
    String place;
    String titleDesc;
    String imgPath;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    Double price;
    Set<TicketForEventDto> tickets;
}
