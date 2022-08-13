package by.kirill.sportsman.app.model.run;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunUpdateDto {

    private Long id;

    private OffsetDateTime startRun;

    private OffsetDateTime finishRun;

    private Double distance;

    private Double average;

    private Long sportsmanId;
}
