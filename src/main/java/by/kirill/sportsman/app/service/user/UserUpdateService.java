package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import org.springframework.stereotype.Service;

@Service
class UserUpdateService {

    private final UserValidationService userValidationService;
    private final UserRepository userRepository;
    private final UserSearchService userSearchService;

    UserUpdateService(
            UserValidationService userValidationService,
            UserRepository userRepository,
            UserSearchService userSearchService) {
        this.userValidationService = userValidationService;
        this.userRepository = userRepository;
        this.userSearchService = userSearchService;
    }

    UserEntity updateUser(UserUpdateReq updateReq) {
        UserEntity user = userSearchService.findById(updateReq.getId());
        userValidationService.validateUserUpdateReq(user, updateReq);
        user.setFirstName(updateReq.getFirstName());
        user.setLastName(updateReq.getLastName());
        user.setBirthday(updateReq.getBirthday());
        user.setEmail(updateReq.getEmail());
        return userRepository.save(user);
    }
}
