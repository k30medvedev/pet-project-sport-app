package by.kirill.sportsman.app.service;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long id) {
        return userRepository.getOne(id);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(@Valid UserEntity user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteByIdCascade(id);
    }

    public UserEntity userUpdate(Long id, UserEntity userEntity) {
        UserEntity user = findById(id);
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setBirthday(userEntity.getBirthday());
        user.setEmail(userEntity.getEmail());
        userRepository.save(user);
        return user;
    }
}