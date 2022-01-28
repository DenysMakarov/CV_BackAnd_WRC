package cv.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cv.backend.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
    Set<Ticket> tickets;
}
