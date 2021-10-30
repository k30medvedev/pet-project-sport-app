package by.kirill.sportsman.app.mapper;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.model.user.UserCreationDto;
import by.kirill.sportsman.app.model.user.UserDto;
import by.kirill.sportsman.app.model.user.UserListDto;
import by.kirill.sportsman.app.model.user.UserUpdateDto;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class UserMapper {

    private UserService userService;
    private final ModelMapper modelMapper;

    public UserMapper(
            UserService userService,
            ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    UserUpdateReq convertDtoToUser(Long id, UserUpdateDto dto) {
        UserUpdateReq model = new UserUpdateReq();
        model.setId(id);
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setEmail(dto.getEmail());
        model.setBirthday(dto.getBirthday());
        return model;
    }

    public void convertDtoToUser(User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
    }

    public User convertDtoToUser(UserCreationDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setBirthday(dto.getBirthday());
        return user;
    }

    public UserDto convertUserToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setBirthday(user.getBirthday());
        return dto;
    }

    public UserListDto getUserListDto() {
        UserListDto userDto = new UserListDto();
        List<User> listUsers = userService.findAll();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        List<UserDto> listUsersDto = modelMapper.map(listUsers, listType);
        userDto.setSportsmans(listUsersDto);
        return userDto;
    }
}
