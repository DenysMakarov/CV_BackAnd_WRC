package cv.backend.model.exeptions;

public class ApiNotFondException extends RuntimeException{
    public ApiNotFondException(String message) {
        super(message);
    }
    public ApiNotFondException(String message, Throwable cause) {
        super(message, cause);
    }
}
