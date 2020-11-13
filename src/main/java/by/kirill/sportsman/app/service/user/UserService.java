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
    private final UserValidationService userValidationService;

    public UserService(UserRepository userRepository, UserValidationService userValidationService) {
        this.userRepository = userRepository;
        this.userValidationService = userValidationService;
    }


    public UserEntity findById(Long id) {
        return userRepository.getOne(id);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) throws EmailAlreadyInUseException {
        userValidationService.validateUserCreationReq(user);
        user.setId(null);
        return userRepository.save(user);
    }



    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteByIdCascade(id);
    }

    public UserEntity updateUser(UserUpdateReq updateReq) {
        UserEntity user = findById(updateReq.getId());
        userValidationService.validateUserUpdateReq(user, updateReq);
        user.setFirstName(updateReq.getFirstName());
        user.setLastName(updateReq.getLastName());
        user.setBirthday(updateReq.getBirthday());
        user.setEmail(updateReq.getEmail());
        userRepository.save(user);
        return user;
    }
}

