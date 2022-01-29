package cv.backend.dto.tickets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TicketForEventDto {
    String id;
    String loginOfUser;
    String nameOfUser;
    String email;
//    String place;
//    Double price;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    LocalDate date = LocalDate.now();
}
