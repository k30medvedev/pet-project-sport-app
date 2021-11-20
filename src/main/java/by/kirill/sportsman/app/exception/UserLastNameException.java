package by.kirill.sportsman.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserLastNameException extends RuntimeException {
    public UserLastNameException(String message) {
        super(message);
    }
}
