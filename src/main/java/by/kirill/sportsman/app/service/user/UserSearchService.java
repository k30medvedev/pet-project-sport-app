package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class UserSearchService {

    private final UserRepository userRepository;

    UserSearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserEntity findById(Long id) {
        return userRepository.getOne(id);
    }

    List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
