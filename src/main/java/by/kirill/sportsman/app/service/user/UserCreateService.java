package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {

    private final UserValidationService userValidationService;
    private final UserRepository userRepository;

    public UserCreateService(UserValidationService userValidationService,
                             UserRepository userRepository) {
        this.userValidationService = userValidationService;
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) throws EmailAlreadyInUseException {
        userValidationService.validateUserCreationReq(user);
        user.setId(null);
        return userRepository.save(user);
    }

}
