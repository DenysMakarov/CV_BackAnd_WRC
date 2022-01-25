package cv.backend.model.exeptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@NoArgsConstructor
@ResponseStatus(HttpStatus.CONFLICT)
public class EntityConflictException extends RuntimeException {
    private static final long serialVersionUID = 3306650791278299160L;
//    public EntityConflict(String login) {
//        super("User " + login + " not found");
//    }
}
