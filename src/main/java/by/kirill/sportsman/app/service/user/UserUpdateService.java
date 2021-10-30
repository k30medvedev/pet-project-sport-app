package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserUpdateService {

    private final UserValidationService userValidationService;
    private final UserRepository userRepository;
    private final UserSearchService userSearchService;

    User updateUser(UserUpdateReq updateReq) {
        User user = userSearchService.findById(updateReq.getId());
        userValidationService.validateUserUpdateReq(user, updateReq);
        user.setFirstName(updateReq.getFirstName());
        user.setLastName(updateReq.getLastName());
        user.setBirthday(updateReq.getBirthday());
        user.setEmail(updateReq.getEmail());
        return userRepository.save(user);
    }
}
