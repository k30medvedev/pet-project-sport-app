//package by.kirill.sportsman.app.controller;
//
//import by.kirill.sportsman.app.model.user.UserCreationRequest;
//import by.kirill.sportsman.app.model.user.UserResponse;
//import by.kirill.sportsman.app.model.user.UserUpdateRequest;
//import by.kirill.sportsman.app.service.user.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import java.util.List;
//
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(path = "/api/v1/sportsmans")
//class UserController {
//    private final UserService userService;
//
//    @GetMapping
//    ResponseEntity<List<UserResponse>> getAll() {
//        return userService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    @ResponseBody
//    ResponseEntity<UserResponse> findUser(@PathVariable @Valid @Min(1)
//                                          @Max(Integer.MAX_VALUE) final Long id) {
//
//        return return ResponseEntity.ok(userService.findById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<UserResponse> createUser(@RequestBody final UserCreationRequest request) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
//    }
//
//    @PutMapping("/sportsmans/{id}")
//    public ResponseEntity<UserResponse> updateUserById(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
//        return ResponseEntity.accepted().body(userService.updateUser(id, request));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<UserResponse> deleteUser(@PathVariable @Valid @Min(1)
//                                                   @Max(Integer.MAX_VALUE) final Long id) {
//        return ResponseEntity.accepted().body(userService.deleteById(id));
//    }
//
//
//}
//
//
//
