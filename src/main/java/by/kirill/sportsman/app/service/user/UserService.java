package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.exception.UserNotFoundException;
import by.kirill.sportsman.app.mapper.UserMapper;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserResponse;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.validation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;
    private final UserRepository userRepository;

    private final UserValidationService validator;

    public UserResponse findById(Long id) {
        return mapper.map(findOneOrThrowException(id));
    }

    public List<UserResponse> findAll() {
        return mapper.map(userRepository.findAll());
    }

    public UserResponse createUser(UserCreationRequest request) {
        validator.validateUserCreationReq(request);
        var user = mapper.map(request);
        return mapper.map(userRepository.save(user));
    }

    @Transactional
    public UserResponse deleteById(Long id) {
        return mapper.map(userRepository.deleteByIdCascade(id));
    }

    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        var user = findOneOrThrowException(id);
        validator.validateUserUpdateReq(user, request);
        var updated = mapper.map(user, request);
        return mapper.map(userRepository.save(updated));
    }

    public User findOneOrThrowException(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id + "User Not found"));
    }

}


