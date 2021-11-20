//package by.kirill.sportsman.app.service.run;
//
//import by.kirill.sportsman.app.domain.Run;
//import by.kirill.sportsman.app.repository.RunRepository;
//import by.kirill.sportsman.app.validation.RunValidationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class RunUpdateTest {
//
//    private RunValidationService runValidationService;
//    private RunRepository runRepository;
//    private RunSearchService runSearchService;
//    private RunUpdateService runUpdateService;
//
//
//    @BeforeEach
//    void setUp() {
//        runValidationService = mock(RunValidationService.class);
//        runRepository = mock(RunRepository.class);
//        runSearchService = mock(RunSearchService.class);
//        runUpdateService = new RunUpdateService(runValidationService, runRepository, runSearchService);
//    }
//
//    @Test
//    void updateRun() {
//
//        //GIVEN
//        Run runRequest = mock(Run.class);
//        Run expectedSearchResult = mock(Run.class);
//        Run expectedUpdateResult = mock(Run.class);
//
//        when(runRequest.getStartRun()).thenReturn(RunConstants.START_RUN);
//        when(runRequest.getFinishRun()).thenReturn(RunConstants.FINISH_RUN);
//        when(runRequest.getDistance()).thenReturn(RunConstants.DISTANCE);
//        when(runRequest.getAverage()).thenReturn(RunConstants.AVERAGE);
//        when(runRequest.getSportsmanId()).thenReturn(12L);
//
//        when(runSearchService.findById(RunConstants.ID)).thenReturn(expectedSearchResult);
//
//        when(runRepository.save(expectedSearchResult)).thenReturn(expectedUpdateResult);
//
//        //WHEN
//        Run actualResult = runUpdateService.updateRun(RunConstants.ID, runRequest);
//
//        //THEN
//        assertEquals(expectedUpdateResult, actualResult);
//        verify(runRequest, times(1)).getStartRun();
//        verify(runRequest, times(1)).getFinishRun();
//        verify(runRequest, times(1)).getDistance();
//        verify(runRequest, times(1)).getAverage();
//
//        verify(runSearchService, only()).findById(RunConstants.ID);
//        verify(runRepository, only()).save(expectedSearchResult);
//        verifyNoMoreInteractions(expectedUpdateResult);
//
//        verify(expectedSearchResult, times(1)).setStartRun(RunConstants.START_RUN);
//        verify(expectedSearchResult, times(1)).setFinishRun(RunConstants.FINISH_RUN);
//        verify(expectedSearchResult, times(1)).setDistance(RunConstants.DISTANCE);
//        verify(expectedSearchResult, times(1)).setAverage(RunConstants.AVERAGE);
//        verify(expectedSearchResult, times(1)).setSportsmanId(12L);
//        verifyNoMoreInteractions(expectedSearchResult);
//    }
//}