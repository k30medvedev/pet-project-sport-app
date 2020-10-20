package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/sportsmans")
    @ResponseBody
    UserListDto getall() {
        UserListDto sportsmanLisDto = new UserListDto();
        List<User> users = userService.findAll();
        sportsmanLisDto.setSportsmens(users);
        return sportsmanLisDto;

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


    @ResponseBody
    @DeleteMapping("/sportsmans/{id}")
    Long deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return id;
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
        userService.saveUser(user);
        return userDto;

    }

}



