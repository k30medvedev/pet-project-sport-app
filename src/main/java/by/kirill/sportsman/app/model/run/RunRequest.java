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
public class RunRequest {

    private OffsetDateTime startRun;

    private OffsetDateTime finishRun;

    private Double distance;

    private Long sportsmanId;

}
