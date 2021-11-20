package by.kirill.sportsman.app.mapper;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserResponse;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User map(User target, UserUpdateRequest src) {
        if (src.getFirstName() != null) {
            target.setFirstName(src.getFirstName());
        }
        if (src.getLastName() != null) {
            target.setLastName(src.getFirstName());
        }
        if (src.getBirthday() != null) {
            target.setBirthday(src.getBirthday());
        }
        if (src.getEmail() != null) {
            target.setEmail(src.getEmail());
        }
        return target;
    }

    public User map(UserCreationRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .birthday(request.getBirthday())
                .build();

    }

    public UserResponse map(User source) {
        return UserResponse.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .birthday(source.getBirthday())
                .build();
    }

    public List<UserResponse> map(List<User> userList) {
        return userList.stream().map(i -> new UserResponse(
                i.getId(),
                i.getFirstName(), i.getLastName(), i.getEmail(),
                i.getBirthday())).collect(Collectors.toList());
    }
}
