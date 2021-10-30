package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class UserSearchService {

    private final UserRepository userRepository;

    List<User> findAll() {
        return userRepository.findAll();
    }

    User findById(Long id) {
        return userRepository.getOne(id);
    }

}
