package cv.backend.dto.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EventSliderDto {
    Long id;
    String titleDesc;
    String imgPath;
    String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    Double price;
}
