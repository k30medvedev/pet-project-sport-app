package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class RunServiceSaveTest {

    private RunService runService;
    private RunRepository runRepository;
    private RunValidationService runValidationService;

    @BeforeEach
    void setUp() {
        runRepository = Mockito.mock(RunRepository.class);
        runValidationService = Mockito.mock(RunValidationService.class);
        runService = new RunService(runRepository, runValidationService);
    }

    @Test
    void shouldThrowExceptionIfValidationFails() {
        // GIVEN
        RunEntity runEntity = Mockito.mock(RunEntity.class);
        Mockito.doThrow(StarGreatThanFinisException.class).when(runValidationService).validateRun(runEntity);

        // WHEN
        Assertions.assertThrows(
                StarGreatThanFinisException.class,
                () -> runService.createRun(runEntity)

        );
        // THEN
        Mockito.verifyNoInteractions(runEntity, runRepository);
        Mockito.verify(runValidationService).validateRun(runEntity);
        Mockito.verifyNoMoreInteractions(runValidationService);
    }

    @Test
    void shouldThrowDistanceNotZeroException() {
        // GIVEN
        RunEntity runEntity = Mockito.mock(RunEntity.class);
        Mockito.doThrow(DistanceNotZeroException.class).when(runValidationService).validateRun(runEntity);

        // WHEN
        Assertions.assertThrows(
                DistanceNotZeroException.class,
                () -> runService.createRun(runEntity)

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