package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setBirthday(user.getBirthday());
        return dto;

    }

    @PostMapping("/sportsmans")
    UserDto createUser(@RequestBody UserCreationDto userCreationDto) {
        User user = new User();
        user.setFirstName(userCreationDto.getFirstName());
        user.setLastName(userCreationDto.getLastName());
        user.setEmail(userCreationDto.getEmail());
        user.setBirthday(userCreationDto.getBirthday());
        user = userService.saveUser(user);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthday(user.getBirthday());
        userDto.setEmail(user.getEmail());
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
    UserDto updateUserbyId(@PathVariable Long id, @RequestBody UserUpdateDto dto) {

        User user = userService.findById(id);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setBirthday(dto.getBirthday());
        user = userService.saveUser(user);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
        return userDto;
    }
  // отдельный класс для конв.
}



