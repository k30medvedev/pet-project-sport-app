//package by.kirill.sportsman.app.service.run;
//
//import by.kirill.sportsman.app.domain.Run;
//import by.kirill.sportsman.app.exception.DistanceNotZeroException;
//import by.kirill.sportsman.app.exception.StarGreatThanFinisException;
//import by.kirill.sportsman.app.repository.RunRepository;
//import by.kirill.sportsman.app.validation.RunValidationService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.mock;
//
//
//class RunServiceCreateTest {
//
//    private RunValidationService runValidationService;
//    private  RunRepository runRepository;
//
//    @BeforeEach
//    void setUp() {
//        runRepository = mock(RunRepository.class);
//        runValidationService = mock(RunValidationService.class);
//
//    }
//
//    @Test
//    void shouldThrowExceptionIfValidationFails() {
//        // GIVEN
//        Run runEntity = mock(Run.class);
//        Mockito.doThrow(StarGreatThanFinisException.class).when(runValidationService).validate(runEntity);
//
//        // WHEN
//        Assertions.assertThrows(
//                StarGreatThanFinisException.class,
//                () -> runCreateRunService.createRun(runEntity)
//
//        );
//        // THEN
//        Mockito.verifyNoInteractions(runEntity, runRepository);
//        Mockito.verify(runValidationService).validate(runEntity);
//        Mockito.verifyNoMoreInteractions(runValidationService);
//    }
//
//    @Test
//    void shouldThrowDistanceNotZeroException() {
//        // GIVEN
//        Run runEntity = mock(Run.class);
//        Mockito.doThrow(DistanceNotZeroException.class).when(runValidationService).validate(runEntity);
//
//        // WHEN
//        Assertions.assertThrows(
//                DistanceNotZeroException.class,
//                () -> runCreateRunService.createRun(runEntity)
//        );
//
//        // THEN
//        Mockito.verifyNoInteractions(runEntity, runRepository);
//        Mockito.verify(runValidationService).validate(runEntity);
//        Mockito.verifyNoMoreInteractions(runValidationService);
//    }
//
//    @Test
//    void shouldSaveEntityInDbWithIdNull() {
//
//    }
//}