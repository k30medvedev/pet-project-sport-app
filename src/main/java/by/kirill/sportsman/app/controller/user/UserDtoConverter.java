package by.kirill.sportsman.app.controller.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.service.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.service.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    private UserService userService;


    UserUpdateReq convertDtoToUser(Long id, UserUpdateDto dto) {
        UserUpdateReq model = new UserUpdateReq();
        model.setId(id);
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setEmail(dto.getEmail());
        model.setBirthday(dto.getBirthday());
        return model;
    }

    public void convertDtoToUser(UserEntity user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
    }

    public UserEntity convertDtoToUser(UserCreationDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setBirthday(dto.getBirthday());
        return userEntity;
    }

    public UserDto convertUserToDto(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setEmail(userEntity.getEmail());
        dto.setBirthday(userEntity.getBirthday());
        return dto;
    }


}
