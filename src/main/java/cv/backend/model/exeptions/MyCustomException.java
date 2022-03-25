package cv.backend.model.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


@Getter
@AllArgsConstructor
public class MyCustomException {
    private final String massage;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
