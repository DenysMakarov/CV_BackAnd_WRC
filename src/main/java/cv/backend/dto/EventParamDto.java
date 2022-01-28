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
public class EventParamDto {
    String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
