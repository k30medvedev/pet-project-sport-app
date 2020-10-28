package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.service.EmailNotInUse.UserUpdateReq;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Service
public class UserValidationService {

    private final UserRepository userRepository;

    UserValidationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void validateUserCreationReq(@Valid UserEntity userCreationReq) throws EmailAlreadyInUseException {
        String email = userCreationReq.getEmail();
        boolean suchEmailAlreadyExists = userRepository.existsByEmailIgnoreCase(email);
        if (suchEmailAlreadyExists) {
            throw new EmailAlreadyInUseException(email);
        }
    }

    void validateUserUpdateReq(@NotNull UserEntity existingUser, @Valid UserUpdateReq userUpdateReq) {
    }
}
