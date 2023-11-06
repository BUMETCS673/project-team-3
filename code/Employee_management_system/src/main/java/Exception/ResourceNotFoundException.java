package Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String credential, String username, String username1) {
        super(String.format("%s not found with %s: %s", credential, username, username1));
    }

    public ResourceNotFoundException(String vacationRequest, String id, int id1) {
        super(String.format("%s not found with %s: %s",vacationRequest , id, id1));
    }
}