//package by.kirill.sportsman.app.service.user;
//
//import by.kirill.sportsman.app.domain.User;
//import by.kirill.sportsman.app.exception.EmailAlreadyInUseException;
//import by.kirill.sportsman.app.repository.UserRepository;
//import by.kirill.sportsman.app.validation.UserValidationService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import java.time.LocalDate;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//class UserCreateUserTest {
//
//    private UserRepository userRepository;
//    private UserValidationService userValidationService;
//    private UserCreateService userCreateService;
//
//    @BeforeEach
//    void setUp() {
//        userRepository = mock(UserRepository.class);
//        userValidationService = mock(UserValidationService.class);
//        userCreateService = new UserCreateService(userValidationService, userRepository);
//    }
//
//    @Test
//    void createNewUserTest() {
//        //GIVEN
//        User user = mock(User.class);
//        LocalDate birthday = LocalDate.of(1914, 7, 28);
//        user.setId(1L);
//        user.setFirstName("Kirill");
//        user.setLastName("Medvedev");
//        user.setEmail("Kirill@tut.by");
//        user.setBirthday(birthday);
//
//        //WHEN
//        when(userRepository.save(user)).thenReturn(user);
//
//        //THEN
//        assertEquals(userCreateService.createUser(user), user);
//        assertNotNull(user);
//        verify(userRepository, times(1)).save(user);
//        verifyNoMoreInteractions(userRepository);
//    }
//
//
//    @Test
//    void createUserEmailAlreadyInUseException() {
//        //GIVEN
//        User user = Mockito.mock(User.class);
//        doThrow(EmailAlreadyInUseException.class).when(userValidationService).validateUserCreationReq(user);
//
//        //WHEN
//        Assertions.assertThrows(
//                EmailAlreadyInUseException.class,
//                () -> userCreateService.createUser(user)
//        );
//
//        //THEN
//        verifyNoInteractions(user, userRepository);
//        verify(userValidationService).validateUserCreationReq(user);
//        verifyNoMoreInteractions(userValidationService);
//    }
//
//}