package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserResponse;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;

import java.util.List;

public interface UserService {

    UserResponse findById(Long id);

    List<UserResponse> findAll();

    UserResponse createUser(UserCreationRequest request);

    UserResponse deleteById(Long id);

    UserResponse updateUser(Long id, UserUpdateRequest request);

}
