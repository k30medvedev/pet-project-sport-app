package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.service.RunService;
import by.kirill.sportsman.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class SportsmansController {
    private final UserService userService;

    public SportsmansController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/sportsmans")
    @ResponseBody
    SportsmanListDto getall() {
        SportsmanListDto sportsmanLisDto = new SportsmanListDto();
        List<User> users = userService.findAll();
        sportsmanLisDto.setSportsmens(users);
        return sportsmanLisDto;
        // return users;
    }

    @PostMapping("/sportsmans")
    User createUser(@RequestBody UserCreationDto userCreationDto) {
        User user = new User();
        user.setFirstName(userCreationDto.getFirstName());
        user.setLastName(userCreationDto.getLastName());
        user.setBirthday(userCreationDto.getBirthday());
        user.setEmail(userCreationDto.getEmail());
        user = userService.saveUser(user);
        return user;
    }


    @ResponseBody
    @DeleteMapping("/sportsmans/{id}")
    Long deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return id;
    }


    @PutMapping("/sportsmans/{id}")
    User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }


}



