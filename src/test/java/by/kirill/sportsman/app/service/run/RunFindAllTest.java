//package by.kirill.sportsman.app.service.run;
//
//import by.kirill.sportsman.app.domain.Run;
//import by.kirill.sportsman.app.repository.RunRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class RunFindAllTest {
//
//
//    private RunRepository runRepository;
//    private RunSearchService runSearchService;
//
//    @BeforeEach
//    void setUp() {
//        runRepository = Mockito.mock(RunRepository.class);
//        runSearchService = new RunSearchService(runRepository);
//    }
//
//    @Test
//    void findAllRuns() {
//        //GIVEN
//        List<Run> listExpected = mock(List.class);
//
//        when(runRepository.findAll()).thenReturn(listExpected);
//        List<Run> listActual = runSearchService.findAllRuns();
//
//        //THEN
//        verify(runRepository, only()).findAll();
//        assertEquals(listExpected,listActual);
//
//        verifyNoInteractions(listExpected);
//    }
//}