package by.kirill.sportsman.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import by.kirill.sportsman.app.config.swagger.user.*;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserResponse;
import by.kirill.sportsman.app.model.user.UserUpdateRequest;
import by.kirill.sportsman.app.service.user.UserService;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/sportsmans")
class UserController {
    private final UserService userService;

    @GetMapping
    @GetUsersOperation
    ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @GetUserOperation
    ResponseEntity<UserResponse> findUser(@PathVariable @Valid @Min(1) @Max(Integer.MAX_VALUE) final Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    @CreateUserOperation
    public ResponseEntity<UserResponse> createUser(final UserCreationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(request));
    }

    @PutMapping("/{id}")
    @UpdateUserOperation
    public ResponseEntity<UserResponse> updateUserById(@PathVariable Long id, @Valid UserUpdateRequest request) {
        return ResponseEntity.accepted()
                .body(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    @DeleteUserOperation
    public ResponseEntity<UserResponse> deleteUser(@PathVariable @Valid @Min(1) @Max(Integer.MAX_VALUE) final Long id) {
        return ResponseEntity.accepted()
                .body(userService.deleteById(id));
    }

}
