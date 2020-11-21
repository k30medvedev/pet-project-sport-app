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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RunUpdateTest {


    private RunValidationService runValidationService;
    private RunRepository runRepository;
    private RunSearchService runSearchService;
    private RunUpdateRun runUpdateRun;

    @BeforeEach
    void setUp() {
        runValidationService = mock(RunValidationService.class);
        runRepository = mock(RunRepository.class);
        runUpdateRun = new RunUpdateRun(runSearchService,runValidationService,runRepository);
    }

    @Test
    void updateRun() {
//
//        //GIVEN
//        final Long id = 227L;
//        final RunEntity expectedSearchResult = mock(RunEntity.class);
//        final RunEntity expectedUpdateResult = mock(RunEntity.class);
//        final RunEntity runRequest = mock(RunEntity.class);
//
//        when(runRequest.getId()).thenReturn(id);
//        when(runRequest.getStartRun()).thenReturn(KeepData.START_RUN);
//        when(runRequest.getFinishRun()).thenReturn(KeepData.FINISH_RUN);
//        when(runRequest.getDistance()).thenReturn(KeepData.DISTANCE);
//        when(runRequest.getAverage()).thenReturn(12.0);
//
//        when(runSearchService.findById(id)).thenReturn(expectedSearchResult);
//
//        when(runRepository.save(expectedSearchResult)).thenReturn(expectedUpdateResult);
//
//        //WHEN
//        RunEntity actualResult = runUpdateRun.updateRun(id,runRequest);
//
//        //THEN
//        assertEquals(expectedUpdateResult,actualResult);


    }

     //Закочнить.
}