package by.kirill.sportsman.app.validation;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;

public interface UserValidationService {

    void validateUserCreationReq(UserCreationRequest request);

    void validateUserUpdateReq(User existingUser, UserUpdateRequest request);
}
