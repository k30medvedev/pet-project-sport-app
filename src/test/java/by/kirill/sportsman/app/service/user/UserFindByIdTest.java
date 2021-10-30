package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserFindByIdTest {

    private UserSearchService userSearchService;
    private UserRepository userRepository;


    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userSearchService = new UserSearchService(userRepository);
    }

    @Test
    void shouldFindById() {
        //GIVEN
        final long id = 117L;
        User actualUser = mock(User.class);

        //WHEN
        when(userRepository.getOne(id)).thenReturn(actualUser);
        User expectedUser = userSearchService.findById(id);

        //THEN
        verify(userRepository, only()).getOne(id);
        assertEquals(expectedUser, actualUser);
    }
}