package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RunFindByIdlTest {


    private RunRepository runRepository;
    private RunSearchService runSearchService;

    @BeforeEach
    void setUp() {
        runRepository = Mockito.mock(RunRepository.class);
        runSearchService = new RunSearchService(runRepository);
    }

    @Test
    void findAllRuns() {
        //GIVEN
       Long id = 117L;
       RunEntity actualRunEntity = mock(RunEntity.class);
       when(runRepository.getOne(id)).thenReturn(actualRunEntity);

       //WHEN
        RunEntity expectedRunEntity =  runSearchService.findById(id);

        //THEN
        verify(runRepository, only()).getOne(id);
        assertEquals(actualRunEntity,expectedRunEntity);
    }
}