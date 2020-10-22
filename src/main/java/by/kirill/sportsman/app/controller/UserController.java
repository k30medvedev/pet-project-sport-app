package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sportsmans")
    @ResponseBody
    UserListDto getall() {
        UserListDto sportsmanLisDto = new UserListDto();
        List<User> users = userService.findAll();
        sportsmanLisDto.setSportsmens(users);
        return sportsmanLisDto;
// переделать
    }

    @GetMapping("/sportsmans/{id}")
    @ResponseBody
    UserDto findUser(@PathVariable Long id) {
        User user = userService.findById(id);
        UserDto dto = new UserDto();
        ConvertUserDtoToUser(user, dto);
        return dto;

    }

    @PostMapping("/sportsmans")
    UserDto createUser(@RequestBody UserCreationDto dto) {
        User user = new User();
        ConvertUserToUserDto(dto, user);
        user = userService.saveUser(user);
        UserDto userDto = new UserDto();
        ConvertUserDtoToUser(user, userDto);
        return userDto;
    }

    @DeleteMapping("/sportsmans/{id}")
    UserDeleteDto deleteUser(@PathVariable("id") Long id) {
        UserDeleteDto dto = new UserDeleteDto();
        userService.deleteById(id);
        User user = userService.findById(id);
        dto.setId(user.getId());
        return dto;
    }

    @PutMapping("/sportsmans/{id}")
    UserDto updateUserById(@PathVariable Long id, @RequestBody UserCreationDto dto) {
        User user = userService.findById(id);
        UserDto userDto = new UserDto();
        ConvertUserDtoToUser(user, userDto);
        user = userService.saveUser(user);
        ConvertUserDtoToUser(user, userDto);
        return userDto;
    }
    private void ConvertUserDtoToUser(User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
    }
    private void ConvertUserToUserDto(@RequestBody UserCreationDto dto, User user) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setBirthday(dto.getBirthday());
    }
}



