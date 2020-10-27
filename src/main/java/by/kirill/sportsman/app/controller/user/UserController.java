package by.kirill.sportsman.app.controller.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.service.Converter;
import by.kirill.sportsman.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;


@RestController
class UserController {
    private final UserService userService;
    private final Converter converter;

    public UserController(UserService userService, Converter converter) {
        this.userService = userService;
        this.converter = converter;
    }


    @GetMapping("/sportsmans")
    @ResponseBody
    UserListDto getall() {
        UserListDto userDto = new UserListDto();
        List<UserEntity> listUsers = userService.findAll();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        List<UserDto> listUsersDto = new ModelMapper().map(listUsers, listType);
        userDto.setSportsmans(listUsersDto);
        return userDto;

    }

    @GetMapping("/sportsmans/{id}")
    @ResponseBody
    UserDto findUser(@PathVariable Long id) {
        UserEntity user = userService.findById(id);
        UserDto dto = new UserDto();
        converter.convertDtoToUser(user, dto);
        return dto;
    }

    @PostMapping("/sportsmans")
    UserDto createUser(@RequestBody UserCreationDto dto) {
        UserEntity userEntity = converter.convertDtoToUser(dto);
        userEntity = userService.saveUser(userEntity);
        return converter.convertUserToDto(userEntity);
    }

    @PutMapping("/sportsmans/{id}")
    UserDto updateUserById(@PathVariable Long id, @RequestBody UserCreationDto dto) {
        UserEntity userEntity = converter.convertDtoToUser(dto);
        userEntity = userService.userUpdate(id, userEntity);
        return converter.convertUserToDto(userEntity);
    }

    @DeleteMapping("/sportsmans/{id}")
    UserDeleteDto deleteUser(@PathVariable("id") Long id) {
        UserDeleteDto dto = new UserDeleteDto();
        userService.deleteById(id);
        UserEntity user = userService.findById(id);
        dto.setId(user.getId());
        return dto;
    }


}



