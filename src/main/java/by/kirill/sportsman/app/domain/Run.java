package by.kirill.sportsman.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@Entity
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "runs")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_run")
    private OffsetDateTime startRun;

    @NotNull
    @Column(name = "finish_run")
    private OffsetDateTime finishRun;

    @NotNull
    @Column(name = "distance")
    private Double distance;

    @NotNull
    @Column(name = "sportsman_id")
    private Long sportsmanId;

    @Column(name = "average")
    private Double average;

}