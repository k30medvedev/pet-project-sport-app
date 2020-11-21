package by.kirill.sportsman.app.model;

import by.kirill.sportsman.app.service.run.KeepData;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class RunEntityTest {

    @Test
    void calculateAverageTest() {
        RunEntity runEntity = new RunEntity();
        Double expectedDistance = 175.609756097561;

        runEntity.setStartRun(KeepData.START_RUN);
        runEntity.setFinishRun(KeepData.FINISH_RUN);
        runEntity.setDistance(KeepData.DISTANCE);
        runEntity.setAverage(runEntity.calculateAverage());

        assertEquals(expectedDistance, runEntity.getAverage());
        assertNotNull(runEntity.getAverage());
    }


    @Test
    void setStartRunTest() {
        OffsetDateTime actualDateTime = KeepData.START_RUN;
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(actualDateTime);
        assertEquals(runEntity.getStartRun(), actualDateTime);
    }

    @Test
    void getStartRunTest() {
        OffsetDateTime dateTime =KeepData.START_RUN;
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dateTime);
        OffsetDateTime expectedDateTime = runEntity.getStartRun();
        assertEquals(expectedDateTime, dateTime);

    }

    @Test
    void setFinishRunTest() {
        OffsetDateTime actualDateTime = KeepData.FINISH_RUN;
        RunEntity runEntity = new RunEntity();
        runEntity.setFinishRun(actualDateTime);
        assertEquals(runEntity.getFinishRun(), actualDateTime);
    }

    @Test
    void getFinishRunTest() {
        OffsetDateTime actualDateTime = KeepData.FINISH_RUN;
        RunEntity runEntity = new RunEntity();
        runEntity.setFinishRun(actualDateTime);
        OffsetDateTime expectedDateTime = runEntity.getFinishRun();
        assertEquals(expectedDateTime, actualDateTime);
    }
}