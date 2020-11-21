package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;


class RunServiceCreateTest {

    private  RunValidationService runValidationService;
    private  RunRepository runRepository;
    private RunCreateRunService runCreateRunService;

    @BeforeEach
    void setUp() {
        runRepository = mock(RunRepository.class);
        runValidationService = mock(RunValidationService.class);
        runCreateRunService = new RunCreateRunService(runValidationService,runRepository);

    }

    @Test
    void shouldThrowExceptionIfValidationFails() {
        // GIVEN
        RunEntity runEntity = mock(RunEntity.class);
        Mockito.doThrow(StarGreatThanFinisException.class).when(runValidationService).validateRun(runEntity);

        // WHEN
        Assertions.assertThrows(
                StarGreatThanFinisException.class,
                () -> runCreateRunService.createRun(runEntity)

        );
        // THEN
        Mockito.verifyNoInteractions(runEntity, runRepository);
        Mockito.verify(runValidationService).validateRun(runEntity);
        Mockito.verifyNoMoreInteractions(runValidationService);
    }

    @Test
    void shouldThrowDistanceNotZeroException() {
        // GIVEN
        RunEntity runEntity = mock(RunEntity.class);
        Mockito.doThrow(DistanceNotZeroException.class).when(runValidationService).validateRun(runEntity);

        // WHEN
        Assertions.assertThrows(
                DistanceNotZeroException.class,
                () -> runCreateRunService.createRun(runEntity)
        );

        // THEN
        Mockito.verifyNoInteractions(runEntity, runRepository);
        Mockito.verify(runValidationService).validateRun(runEntity);
        Mockito.verifyNoMoreInteractions(runValidationService);
    }

    @Test
    void shouldSaveEntityInDbWithIdNull() {

    }
}