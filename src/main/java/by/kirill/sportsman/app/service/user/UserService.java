package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.exception.EmailAlreadyInUseException;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateService userCreateService;
    private final UserUpdateService userUpdateService;
    private final UserSearchService userSearchService;

    public User findById(Long id) {
        return userSearchService.findById(id);
    }

    public List<User> findAll() {
        return userSearchService.findAll();
    }

    public User createUser(User user) throws EmailAlreadyInUseException {
        return userCreateService.createUser(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteByIdCascade(id);
    }

    public User updateUser(UserUpdateReq updateReq) {
        return userUpdateService.updateUser(updateReq);
    }

}


