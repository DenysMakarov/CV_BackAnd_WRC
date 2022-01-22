package cv.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cv.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDto {
    long id;
    String event;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    String phoneNumber;
    String place;
    boolean expDate;
}
