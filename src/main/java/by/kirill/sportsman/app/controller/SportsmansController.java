package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    SportsmanLisDto getall() {
        SportsmanLisDto sportsmanLisDto = new SportsmanLisDto();
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
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/sportsmans/{id}")
    String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "id:" + id + " was deleted successfully" + HttpStatus.OK;
    }

    @PutMapping("/sportsmans/{id}")
    User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }


}



