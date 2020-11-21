package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserFindAllTest {


    private UserSearchService userSearchService;
    private UserRepository userRepository;


    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userSearchService = new UserSearchService(userRepository);
    }


    @Test
    void shouldFindAllTest() {
        //GIVEN
        List<UserEntity> listExpected = mock(List.class);

        //WHEN
        when(userRepository.findAll()).thenReturn(listExpected);
        List<UserEntity> listActual = userSearchService.findAll();

        //THEN
        verify(userRepository, only()).findAll();
        assertEquals(listExpected,listActual);

        verifyNoInteractions(listExpected);
    }

}
