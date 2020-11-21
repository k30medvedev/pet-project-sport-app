package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceDeleteByIdTest {


    private UserRepository userRepository;
    private UserCreateService userCreateService;
    private UserService userService;
    private UserUpdateService userUpdateService;
    private UserSearchService userSearchService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userCreateService = Mockito.mock(UserCreateService.class);
        userUpdateService = Mockito.mock(UserUpdateService.class);
        userSearchService = Mockito.mock(UserSearchService.class);
        userService = new UserService(userRepository, userCreateService, userUpdateService, userSearchService);
    }

    @Test
    void shouldDeleteById() {
        //GIVEN
        Long id = 227L;
        doNothing().when(userRepository).deleteById(id);

        //WHEN
        userService.deleteById(id);

        //THEN
        verify(userRepository, only()).deleteByIdCascade(id);

    }
}