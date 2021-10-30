//package by.kirill.sportsman.app.model;
//
//import by.kirill.sportsman.app.domain.RunEntity;
//import by.kirill.sportsman.app.service.run.RunConstants;
//import org.junit.jupiter.api.Test;
//
//import java.time.OffsetDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RunEntityTest {
//
//    @Test
//    void calculateAverageTest() {
//        RunEntity runEntity = new RunEntity();
//        Double expectedDistance = 175.609756097561;
//
//        runEntity.setStartRun(RunConstants.START_RUN);
//        runEntity.setFinishRun(RunConstants.FINISH_RUN);
//        runEntity.setDistance(RunConstants.DISTANCE);
//        runEntity.setAverage(runEntity.calculateAverage());
//
//        assertEquals(expectedDistance, runEntity.getAverage());
//        assertNotNull(runEntity.getAverage());
//    }
//
//
//    @Test
//    void setStartRunTest() {
//        OffsetDateTime actualDateTime = RunConstants.START_RUN;
//        RunEntity runEntity = new RunEntity();
//        runEntity.setStartRun(actualDateTime);
//        assertEquals(runEntity.getStartRun(), actualDateTime);
//    }
//
//    @Test
//    void getStartRunTest() {
//        OffsetDateTime dateTime = RunConstants.START_RUN;
//        RunEntity runEntity = new RunEntity();
//        runEntity.setStartRun(dateTime);
//        OffsetDateTime expectedDateTime = runEntity.getStartRun();
//        assertEquals(expectedDateTime, dateTime);
//
//    }
//
//    @Test
//    void setFinishRunTest() {
//        OffsetDateTime actualDateTime = RunConstants.FINISH_RUN;
//        RunEntity runEntity = new RunEntity();
//        runEntity.setFinishRun(actualDateTime);
//        assertEquals(runEntity.getFinishRun(), actualDateTime);
//    }
//
//    @Test
//    void getFinishRunTest() {
//        OffsetDateTime actualDateTime = RunConstants.FINISH_RUN;
//        RunEntity runEntity = new RunEntity();
//        runEntity.setFinishRun(actualDateTime);
//        OffsetDateTime expectedDateTime = runEntity.getFinishRun();
//        assertEquals(expectedDateTime, actualDateTime);
//    }
//}