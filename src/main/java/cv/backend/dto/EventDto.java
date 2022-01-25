package cv.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EventDto {
    String textTop;
    String imgPath;
    String textCenter;
    String textBottom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    String price;
}
