package by.kirill.sportsman.app.service.user;

import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.UserRepository;
import by.kirill.sportsman.app.service.user.EmailNotInUse.UserUpdateReq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUpdateTest {

    private UserRepository userRepository;
    private UserValidationService userValidationService;
    private UserSearchService userSearchService;
    private UserUpdateService userUpdateService;


    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userValidationService = Mockito.mock(UserValidationService.class);
        userSearchService = Mockito.mock(UserSearchService.class);
        userUpdateService = new UserUpdateService(userValidationService, userRepository, userSearchService);
    }

    @Test
    void shouldUpdateUserName() {

        //GIVEN
        final LocalDate birthday = LocalDate.of(1914, 7, 28);
        final UserUpdateReq updateReq = Mockito.mock(UserUpdateReq.class);
        final UserEntity expectedSearchResult = Mockito.mock(UserEntity.class);
        final UserEntity expectedUpdateResult = Mockito.mock(UserEntity.class);

        long id = 227L;
        when(updateReq.getId()).thenReturn(id);
        when(updateReq.getFirstName()).thenReturn("Jonn");
        when(updateReq.getLastName()).thenReturn("Milton");
        when(updateReq.getBirthday()).thenReturn(birthday);
        when(updateReq.getEmail()).thenReturn("222@tut.by");

        when(userSearchService.findById(id)).thenReturn(expectedSearchResult);

        when(userRepository.save(expectedSearchResult)).thenReturn(expectedUpdateResult);

        //WHEN
        UserEntity actualResult = userUpdateService.updateUser(updateReq);

        //THEN
        assertEquals(expectedUpdateResult, actualResult);
        verify(updateReq, times(1)).getId();
        verify(updateReq, times(1)).getFirstName();
        verify(updateReq, times(1)).getLastName();
        verify(updateReq, times(1)).getBirthday();
        verify(updateReq, times(1)).getEmail();
        verifyNoMoreInteractions(updateReq);

        verify(userValidationService, only()).validateUserUpdateReq(expectedSearchResult, updateReq);

        verify(userSearchService, only()).findById(id);

        verify(userRepository, only()).save(expectedSearchResult);

        verifyNoInteractions(expectedUpdateResult);

        verify(expectedSearchResult, times(1)).setFirstName("Jonn");
        verify(expectedSearchResult, times(1)).setLastName("Milton");
        verify(expectedSearchResult, times(1)).setBirthday(LocalDate.of(1914, 7, 28));
        verify(expectedSearchResult, times(1)).setEmail("222@tut.by");
        verifyNoMoreInteractions(expectedSearchResult);
    }

}