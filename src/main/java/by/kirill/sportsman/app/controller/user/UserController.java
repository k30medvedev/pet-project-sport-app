package by.kirill.sportsman.app.controller.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import by.kirill.sportsman.app.service.user.EmailAlreadyInUseException;
import by.kirill.sportsman.app.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


@RestController
class UserController {
    private final UserService userService;
    private final UserDtoConverter userDtoConverter;
    private final ModelMapper modelMapper;

    public UserController(
            UserService userService,
            UserDtoConverter userDtoConverter,
            ModelMapper modelMapper) {
        this.userService = userService;
        this.userDtoConverter = userDtoConverter;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/sportsmans")
    @ResponseBody
    UserListDto getAll() {
        return userDtoConverter.getUserListDto();
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



