package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.service.run.RunService;
import by.kirill.sportsman.app.service.run.RunValidationService;
import by.kirill.sportsman.app.service.run.StarGreatThanFinisException;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import liquibase.pro.packaged.U;
import org.apache.catalina.User;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class UserServiceTest {

    private UserRepository userRepository;
    private UserValidationService userValidationService;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userValidationService = Mockito.mock(UserValidationService.class);
        userService = new UserService(userRepository, userValidationService);
    }


    @Test
    void shouldFindById() {
        //GIVEN
        final long id = 1L;
        UserEntity userExpected = Mockito.mock(UserEntity.class);
        Mockito.when(userService.findById(id)).thenReturn(userExpected);

        //WHEN
        UserEntity userActual = userService.findById(id);

        //THEN
        assertEquals(userActual, userExpected);
        verify(userRepository, Mockito.only()).getOne(id);
        verifyNoInteractions(userExpected, userValidationService);

        // UserSearchService переделать.
    }


    @Test
    void findAllTestIsEmpty() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(userService.findAll().isEmpty());
    }


    @Test
    void findAllTest() {
        //GIVEN
        UserEntity userEntityOne = Mockito.mock(UserEntity.class);
        UserEntity userEntityTwo = Mockito.mock(UserEntity.class);

        List<UserEntity> list = new ArrayList<>();
        list.add(userEntityOne);
        list.add(userEntityTwo);
        //WHEN
        when(userRepository.findAll()).thenReturn(list);
        List<UserEntity> result = userService.findAll();
        //THEN
        assertNotNull(result);
        assertEquals(2, list.size());
        assertEquals(userService.findAll(), list);
        verify(userRepository, Mockito.times(2)).findAll();
    }


    @Test
    void createNewUserTest() {
        //GIVEN
        UserEntity userEntity = Mockito.mock(UserEntity.class);
        LocalDate birthday = LocalDate.of(1914, 7, 28);
        userEntity.setId(1L);
        userEntity.setFirstName("Kirill");
        userEntity.setLastName("Medvedev");
        userEntity.setEmail("Kirill@tut.by");
        userEntity.setBirthday(birthday);

        //WHEN
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        //THEN
        assertEquals(userService.createUser(userEntity), userEntity);
        assertNotNull(userEntity);
        verify(userRepository, Mockito.times(1)).save(userEntity);
        verifyNoMoreInteractions(userRepository);
    }


    @Test
    void deleteById() {

    }  // не работает.

    @Test
    void updateUser() {
        UserUpdateReq userUpdateReq = Mockito.mock(UserUpdateReq.class);
        UserEntity userEntity = Mockito.mock(UserEntity.class);
        LocalDate birthday = LocalDate.of(1914, 7, 28);
        userUpdateReq.setId(1L);
        userUpdateReq.setFirstName("Kirill");
        userUpdateReq.setLastName("Medvedev");
        userUpdateReq.setEmail("Kirill@tut.by");
        userUpdateReq.setBirthday(birthday);

        when(userService.findById(1L)).thenReturn(userEntity);
        when(userService.updateUser(userUpdateReq)).thenReturn(userEntity);

// не работает.

    }


    @Test
    void createUserEmailAlreadyInUseException() {
        //GIVEN
        UserEntity userEntity = Mockito.mock(UserEntity.class);
        Mockito.doThrow(EmailAlreadyInUseException.class).when(userValidationService).validateUserCreationReq(userEntity);

        //WHEN
        Assertions.assertThrows(
                EmailAlreadyInUseException.class,
                () -> userService.createUser(userEntity)
        );

        //THEN
        Mockito.verifyNoInteractions(userEntity, userRepository);
        Mockito.verify(userValidationService).validateUserCreationReq(userEntity);
        Mockito.verifyNoMoreInteractions(userValidationService);
    }


}