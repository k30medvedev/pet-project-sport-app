package by.kirill.sportsman.app.validation;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.exception.EmailAlreadyInUseException;
import by.kirill.sportsman.app.exception.UserLastNameException;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;
import by.kirill.sportsman.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
public class UserValidationService {

    private final UserRepository userRepository;

    public void validateUserCreationReq(@Valid UserCreationRequest request) {
        String email = request.getEmail();
        boolean suchEmailAlreadyExists = userRepository.existsByEmailIgnoreCase(email);
        if (suchEmailAlreadyExists) {
            throw new EmailAlreadyInUseException(email);
        }
    }

    public void validateUserUpdateReq(User existingUser, UserUpdateRequest request) {
        if (request.getLastName() == null) {
            throw new UserLastNameException("Last name is mondatory");
        }
    }
}
