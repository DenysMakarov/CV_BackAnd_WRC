package cv.backend.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApiNotFondException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiNotFondException e, WebRequest webRequest) {
        MyCustomException myNotFoundException = new MyCustomException(
                e.getMessage(),
//                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now());
        return new ResponseEntity<>(myNotFoundException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ApiConflictException.class})
    public ResponseEntity<Object> handleApiRequestConflictException(ApiConflictException e, WebRequest webRequest) {
        MyCustomException myConflictException = new MyCustomException(
                e.getMessage(),
//                e,
                HttpStatus.CONFLICT,
                ZonedDateTime.now());
        return new ResponseEntity<>(myConflictException, HttpStatus.NOT_FOUND);
    }
}
