package cv.backend.model.exeptions;

public class ApiConflictException extends RuntimeException{
    public ApiConflictException(String message) {
        super(message);
    }
    public ApiConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
