package cv.backend.model.exeptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    private static final long serialVersionUID = -622843359855547989L;

    public EntityNotFoundException(String login) {
        super("User" + login + " not found");
    }
}
