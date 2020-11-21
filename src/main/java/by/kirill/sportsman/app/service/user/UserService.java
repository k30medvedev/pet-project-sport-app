package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateService userCreateService;
    private final UserUpdateService userUpdateService;
    private final UserSearchService userSearchService;

    public UserService(
            UserRepository userRepository,
            UserCreateService userCreateService,
            UserUpdateService userUpdateService,
            UserSearchService userSearchService) {
        this.userRepository = userRepository;
        this.userCreateService = userCreateService;
        this.userUpdateService = userUpdateService;
        this.userSearchService = userSearchService;
    }


    public UserEntity findById(Long id) {
        return userSearchService.findById(id);
    }

    public List<UserEntity> findAll() {
        return userSearchService.findAll();
    }

    public UserEntity createUser(UserEntity user) throws EmailAlreadyInUseException {
        return userCreateService.createUser(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteByIdCascade(id);
    }

    public UserEntity updateUser(UserUpdateReq updateReq) {
        return userUpdateService.updateUser(updateReq);
    }

}


