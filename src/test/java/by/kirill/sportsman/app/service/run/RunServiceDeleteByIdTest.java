//package by.kirill.sportsman.app.service.run;
//
//import by.kirill.sportsman.app.repository.RunRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class RunServiceDeleteByIdTest {
//
//    private RunRepository runRepository;
//    private RunSearchService runSearchService;
//    private RunUpdateService runUpdateService;
//    private RunCreateRunService runCreateRunService;
//    private RunService runService;
//
//
//    @BeforeEach
//    void setUp() {
//        runRepository = Mockito.mock(RunRepository.class);
//        runSearchService = Mockito.mock(RunSearchService.class);
//        runUpdateService = Mockito.mock(RunUpdateService.class);
//        runCreateRunService = Mockito.mock(RunCreateRunService.class);
//        runService = new RunService(runRepository,runSearchService,runUpdateService,runCreateRunService);
//    }
//
//    @Test
//    void deleteById() {
//        //GIVEN
//        Long id = 227L;
//        doNothing().when(runRepository).deleteById(id);
//
//        //WHEN
//        runService.deleteById(id);
//
//        //THEN
//        verify(runRepository, only()).deleteById(id);
//
//    }
//}