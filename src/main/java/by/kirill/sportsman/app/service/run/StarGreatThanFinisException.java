package by.kirill.sportsman.app.service.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StarGreatThanFinisException extends RuntimeException {
    public StarGreatThanFinisException(String message) {
        super(message);
    }
}
