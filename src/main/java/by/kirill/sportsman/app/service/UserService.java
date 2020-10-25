package by.kirill.sportsman.app.service;

import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
@Validated
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public User findById(Long id) { return userRepository.getOne(id); }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(@Valid  User user) {
        return userRepository.save(user);
    }
    @Transactional
    public void deleteById(Long id) { userRepository.deleteByIdCascade(id); }

    public boolean ifExist(Long id) {
        return userRepository.existsById(id);
    }




}
