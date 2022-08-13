package by.kirill.sportsman.app.validation;

import org.springframework.stereotype.Service;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.exception.EmailAlreadyInUseException;
import by.kirill.sportsman.app.exception.UserLastNameException;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;
import by.kirill.sportsman.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {

    private final UserRepository userRepository;

    public void validateUserCreationReq(UserCreationRequest request) {
        String email = request.getEmail();
        boolean suchEmailAlreadyExists = userRepository.existsByEmailIgnoreCase(email);
        if (suchEmailAlreadyExists) {
            throw new EmailAlreadyInUseException(email);
        }
    }

    public void validateUserUpdateReq(User existingUser, UserUpdateRequest request) {
        if (request.getLastName() == null) {
            throw new UserLastNameException("Last name is mandatory");
        }
    }
}
