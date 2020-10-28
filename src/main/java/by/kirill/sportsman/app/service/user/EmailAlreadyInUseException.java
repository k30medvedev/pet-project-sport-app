package by.kirill.sportsman.app.service.user;

public class EmailAlreadyInUseException extends Throwable {
    public EmailAlreadyInUseException(String message) {
        super(message);
    }
}
