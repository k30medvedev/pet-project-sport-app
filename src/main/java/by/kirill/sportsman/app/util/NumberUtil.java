package by.kirill.sportsman.app.util;

import java.time.OffsetDateTime;

public final class NumberUtil {

    private NumberUtil() {
    }

    public static Double calculateAverage(OffsetDateTime finishRun, OffsetDateTime startRun, Double distance) {
        long dif = finishRun.toEpochSecond() - startRun.toEpochSecond();
        return dif / distance;
    }

}
