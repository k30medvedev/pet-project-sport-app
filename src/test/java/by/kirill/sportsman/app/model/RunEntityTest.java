package by.kirill.sportsman.app.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class RunEntityTest {

    @Test
    void calculateAverageTest() {
        RunEntity runEntity = new RunEntity();
        Double distance = 20.5;
        Double expectedDistance = 175.609756097561;
        ZoneId zone = ZoneId.of("+03:00");
        OffsetDateTime startRun = OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        OffsetDateTime finishRin = OffsetDateTime.of(2020, 5, 20, 10, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        runEntity.setStartRun(startRun);
        runEntity.setFinishRun(finishRin);
        runEntity.setDistance(distance);

        runEntity.setAverage(runEntity.calculateAverage());

        assertEquals(expectedDistance, runEntity.getAverage());
        assertNotNull(runEntity.getAverage());
    }


    @Test
    void setStartRunTest() {
        ZoneId zone = ZoneId.of("+03:00");
        OffsetDateTime dateTime = OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dateTime);
        assertEquals(runEntity.getStartRun(), dateTime);
    }

    @Test
    void getStartRunTest() {
        ZoneId zone = ZoneId.of("+03:00");
        OffsetDateTime dateTime = OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dateTime);
        OffsetDateTime result = runEntity.getStartRun();
        assertEquals(result, dateTime);

    }

    @Test
    void setFinishRunTest() {
        ZoneId zone = ZoneId.of("+03:00");
        OffsetDateTime dateTime = OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        RunEntity runEntity = new RunEntity();
        runEntity.setFinishRun(dateTime);
        assertEquals(runEntity.getFinishRun(), dateTime);
    }

    @Test
    void getFinishRunTest() {
        ZoneId zone = ZoneId.of("+03:00");
        OffsetDateTime dateTime = OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        RunEntity runEntity = new RunEntity();
        runEntity.setFinishRun(dateTime);
        OffsetDateTime result = runEntity.getFinishRun();
        assertEquals(result, dateTime);
    }
}