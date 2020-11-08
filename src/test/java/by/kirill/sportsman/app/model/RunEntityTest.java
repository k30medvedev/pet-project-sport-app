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
        ZoneId zone = ZoneId.of("+03:00");
        OffsetDateTime startRun = OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        OffsetDateTime finishRin = OffsetDateTime.of(2020, 5, 20, 10, 10, 40,
                50000, ZoneOffset.of(String.valueOf(zone)));
        runEntity.setStartRun(startRun);
        runEntity.setFinishRun(finishRin);
        runEntity.setDistance(distance);
        runEntity.setAverage(runEntity.calculateAverage());
        Double average = (finishRin.toEpochSecond()-startRun.toEpochSecond())/distance;
        assertEquals(runEntity.getAverage(),average);
    }

    @Test
    void setAverageTest() {
        Double average = 20.5;
        RunEntity runEntity = new RunEntity();
        runEntity.setAverage(average);
        assertEquals(runEntity.getAverage(), average);
    }

    @Test
    void getAverageTest() {
        RunEntity runEntity = new RunEntity();
        Double average = 20.5;
        runEntity.setAverage(average);
        Double result = runEntity.getAverage();
        assertEquals(result, average);
    }

    @Test
    void setSportsmanIdTest() {
        Long id = 20l;
        RunEntity runEntity = new RunEntity();
        runEntity.setSportsmanId(id);
        assertEquals(runEntity.getSportsmanId(), id);
    }

    @Test
    void getSportsmanIdTest() {
        RunEntity runEntity = new RunEntity();
        Long id = 20l;
        runEntity.setSportsmanId(id);
        Long result = runEntity.getSportsmanId();
        assertEquals(result, id);
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

    @Test
    void setIdTest() {
        RunEntity runEntity = new RunEntity();
        Long id = 20l;
        runEntity.setId(id);
        Long result = runEntity.getId();
        assertEquals(result, id);
    }

    @Test
    void getIdTest() {
        RunEntity runEntity = new RunEntity();
        Long id = 20l;
        runEntity.setId(id);
        Long result = runEntity.getId();
        assertEquals(result, id);
    }

    @Test
    void setDistanceTest() {
        Double distance = 20.0;
        RunEntity runEntity = new RunEntity();
        runEntity.setDistance(distance);
        assertEquals(runEntity.getDistance(), distance);

    }

    @Test
    void getDistanceTest() {
        RunEntity runEntity = new RunEntity();
        Double distance = 20.0;
        runEntity.setDistance(distance);
        Double result = runEntity.getDistance();
        assertEquals(result, distance);
    }
}