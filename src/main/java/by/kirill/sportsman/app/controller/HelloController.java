package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class HelloController {
    private final UserService userService;

    public HelloController(UserService userService) {
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


//    @GetMapping("/sportsmens/{id}")
//    public ResponseEntity<String> findById(@PathVariable String id) {
//        return new ResponseEntity<String>("GET Response", HttpStatus.OK);
//    }
//
//    @PutMapping("/sportsmens/{id}")
//    public @ResponseBody
//    ResponseEntity<String> put(@PathVariable String id) {
//        return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
//
//    }

    //    @DeleteMapping("/sportsmens/{id}") {
//        public @ResponseBody ResponseEntity<String> deleteById(){
//            return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
//        }
//
//    ;
//


//
//    @PutMapping("/sportsmens/{id}") {
//        public String
//        return "user "
//
//    }
//

}