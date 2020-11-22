package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RunUpdateTest {

    private RunValidationService runValidationService;
    private RunRepository runRepository;
    private RunSearchService runSearchService;
    private RunUpdateService runUpdateService;


    @BeforeEach
    void setUp() {
        runValidationService = mock(RunValidationService.class);
        runRepository = mock(RunRepository.class);
        runSearchService = mock(RunSearchService.class);
        runUpdateService = new RunUpdateService(runValidationService, runRepository, runSearchService);
    }

    @Test
    void updateRun() {

        //GIVEN
        RunEntity runRequest = mock(RunEntity.class);
        RunEntity expectedSearchResult = mock(RunEntity.class);
        RunEntity expectedUpdateResult = mock(RunEntity.class);

        when(runRequest.getStartRun()).thenReturn(RunConstants.START_RUN);
        when(runRequest.getFinishRun()).thenReturn(RunConstants.FINISH_RUN);
        when(runRequest.getDistance()).thenReturn(RunConstants.DISTANCE);
        when(runRequest.getAverage()).thenReturn(RunConstants.AVERAGE);
        when(runRequest.getSportsmanId()).thenReturn(12L);

        when(runSearchService.findById(RunConstants.ID)).thenReturn(expectedSearchResult);

        when(runRepository.save(expectedSearchResult)).thenReturn(expectedUpdateResult);

        //WHEN
        RunEntity actualResult = runUpdateService.updateRun(RunConstants.ID, runRequest);

        //THEN
        assertEquals(expectedUpdateResult, actualResult);
        verify(runRequest, times(1)).getStartRun();
        verify(runRequest, times(1)).getFinishRun();
        verify(runRequest, times(1)).getDistance();
        verify(runRequest, times(1)).getAverage();

        verify(runSearchService, only()).findById(RunConstants.ID);
        verify(runRepository, only()).save(expectedSearchResult);
        verifyNoMoreInteractions(expectedUpdateResult);

        verify(expectedSearchResult, times(1)).setStartRun(RunConstants.START_RUN);
        verify(expectedSearchResult, times(1)).setFinishRun(RunConstants.FINISH_RUN);
        verify(expectedSearchResult, times(1)).setDistance(RunConstants.DISTANCE);
        verify(expectedSearchResult, times(1)).setAverage(RunConstants.AVERAGE);
        verify(expectedSearchResult, times(1)).setSportsmanId(12L);
        verifyNoMoreInteractions(expectedSearchResult);
    }
}