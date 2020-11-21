package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoInteractions;

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
        UserEntity actualUserEntity = mock(UserEntity.class);

        //WHEN
        when(userRepository.getOne(id)).thenReturn(actualUserEntity);
        UserEntity expectedUserEntity = userSearchService.findById(id);

        //THEN
        verify(userRepository, only()).getOne(id);
        assertEquals(expectedUserEntity,actualUserEntity);
    }
}