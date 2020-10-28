package by.kirill.sportsman.app.controller.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.service.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.service.user.EmailAlreadyInUseException;
import by.kirill.sportsman.app.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;


@RestController
class UserController {
    private final UserService userService;
    private final UserDtoConverter userDtoConverter;

    public UserController(UserService userService,  UserDtoConverter userDtoConverter) {
        this.userService = userService;
        this.userDtoConverter = userDtoConverter;
    }


    @GetMapping("/sportsmans")
    @ResponseBody
    UserListDto getall() {
        UserListDto userDto = new UserListDto();
        List<UserDto> listUsersDto = convertToLIstDto();
        userDto.setSportsmans(listUsersDto);
        return userDto;
    }
    private List<UserDto> convertToLIstDto() {
        List<UserEntity> listUsers = userService.findAll();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        return new ModelMapper().map(listUsers, listType);
    }

    @GetMapping("/sportsmans/{id}")
    @ResponseBody
    UserDto findUser(@PathVariable Long id) {
        UserEntity user = userService.findById(id);
        UserDto dto = new UserDto();
        userDtoConverter.convertDtoToUser(user, dto);
        return dto;
    }

    @PostMapping("/sportsmans")
    UserDto createUser(@RequestBody UserCreationDto dto) throws EmailAlreadyInUseException {
        UserEntity userEntity = userDtoConverter.convertDtoToUser(dto);
        userEntity = userService.createUser(userEntity);
        return userDtoConverter.convertUserToDto(userEntity);
    }

    @PutMapping("/sportsmans/{id}")
    UserDto updateUserById(@PathVariable Long id, @RequestBody UserUpdateDto dto) {
        UserUpdateReq req = userDtoConverter.convertDtoToUser(id, dto);
        UserEntity userEntity = userService.updateUser(req);
        return userDtoConverter.convertUserToDto(userEntity);
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



