package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<User> listExpected = mock(List.class);

        //WHEN
        when(userRepository.findAll()).thenReturn(listExpected);
        List<User> listActual = userSearchService.findAll();

        //THEN
        verify(userRepository, only()).findAll();
        assertEquals(listExpected,listActual);

        verifyNoInteractions(listExpected);
    }

}
