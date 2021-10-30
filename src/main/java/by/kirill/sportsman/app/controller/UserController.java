package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.mapper.UserMapper;
import by.kirill.sportsman.app.model.user.*;
import by.kirill.sportsman.app.exception.EmailAlreadyInUseException;
import by.kirill.sportsman.app.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;


    @GetMapping("/sportsmans")
    @ResponseBody
    UserListDto getAll() {
        return userMapper.getUserListDto();
    }

    @GetMapping("/sportsmans/{id}")
    @ResponseBody
    UserDto findUser(@PathVariable Long id) {
        User user = userService.findById(id);
        UserDto dto = new UserDto();
        userMapper.convertDtoToUser(user, dto);
        return dto;
    }

    @PostMapping("/sportsmans")
    UserDto createUser(@RequestBody UserCreationDto dto) throws EmailAlreadyInUseException {
        User user = userMapper.convertDtoToUser(dto);
        user = userService.createUser(user);
        return userMapper.convertUserToDto(user);
    }

//    @PutMapping("/sportsmans/{id}")
//    UserDto updateUserById(@PathVariable Long id, @RequestBody UserUpdateDto dto) {
//        UserUpdateReq req = userMapper.convertDtoToUser(id, dto);
//        UserEntity userEntity = userService.updateUser(req);
//        return userMapper.convertUserToDto(userEntity);
//    }

    @DeleteMapping("/sportsmans/{id}")
    UserDeleteDto deleteUser(@PathVariable("id") Long id) {
        UserDeleteDto dto = new UserDeleteDto();
        userService.deleteById(id);
        User user = userService.findById(id);
        dto.setId(user.getId());
        return dto;
    }


}



