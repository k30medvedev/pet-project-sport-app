package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.exception.EmailAlreadyInUseException;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UserValidationService userValidationService;
    private final UserRepository userRepository;

    public User createUser(User user) throws EmailAlreadyInUseException {
        userValidationService.validateUserCreationReq(user);
        user.setId(null);
        return userRepository.save(user);
    }

}
