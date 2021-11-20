package by.kirill.sportsman.app.model.run;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunResponse {
    private Long id;

    private OffsetDateTime startRun;

    private OffsetDateTime finishRun;

    private Double distance;

    private Double average;

    private Long sportsmanId;
}
