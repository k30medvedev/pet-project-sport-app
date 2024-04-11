package by.kirill.sportsman.app.service.run;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class RunConstants {
    public static final OffsetDateTime START_RUN =
            OffsetDateTime.of(2020, 5, 20, 9, 10, 40,
            50000, ZoneOffset.of(String.valueOf(ZoneId.of("+03:00"))));

    public static final OffsetDateTime FINISH_RUN =
            OffsetDateTime.of(2020, 5, 20, 10, 10, 40,
            50000, ZoneOffset.of(String.valueOf(ZoneId.of("+03:00"))));

    public static final Double DISTANCE = 20.5;
    public static final Long ID = 227L;
    public static final Double AVERAGE = 12.0;
 //test 2

}
