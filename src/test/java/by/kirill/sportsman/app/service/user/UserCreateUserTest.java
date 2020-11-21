package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UserCreateUserTest {

    private UserRepository userRepository;
    private UserValidationService userValidationService;
    private UserCreateService userCreateService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userValidationService = mock(UserValidationService.class);
        userCreateService = new UserCreateService(userValidationService, userRepository);
    }

    @Test
    void createNewUserTest() {
        //GIVEN
        UserEntity userEntity = mock(UserEntity.class);
        LocalDate birthday = LocalDate.of(1914, 7, 28);
        userEntity.setId(1L);
        userEntity.setFirstName("Kirill");
        userEntity.setLastName("Medvedev");
        userEntity.setEmail("Kirill@tut.by");
        userEntity.setBirthday(birthday);

        //WHEN
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        //THEN
        assertEquals(userCreateService.createUser(userEntity), userEntity);
        assertNotNull(userEntity);
        verify(userRepository, times(1)).save(userEntity);
        verifyNoMoreInteractions(userRepository);
    }


    @Test
    void createUserEmailAlreadyInUseException() {
        //GIVEN
        UserEntity userEntity = Mockito.mock(UserEntity.class);
        doThrow(EmailAlreadyInUseException.class).when(userValidationService).validateUserCreationReq(userEntity);

        //WHEN
        Assertions.assertThrows(
                EmailAlreadyInUseException.class,
                () -> userCreateService.createUser(userEntity)
        );

        //THEN
        verifyNoInteractions(userEntity, userRepository);
        verify(userValidationService).validateUserCreationReq(userEntity);
        verifyNoMoreInteractions(userValidationService);
    }

}