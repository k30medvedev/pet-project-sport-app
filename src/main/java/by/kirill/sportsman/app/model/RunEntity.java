package by.kirill.sportsman.app.model;

import by.kirill.sportsman.app.validation.ValidateStartFinish;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "runs")
public class RunEntity {
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

    public Double calculateAverage() {
        long dif = finishRun.toEpochSecond() - startRun.toEpochSecond();
        Double average = dif / distance;
        return average;
    }

    public Double getAverage() {
        return average;
    }


    public void setAverage(Double average) {
        this.average = average;
    }


    public Long getSportsmanId() {
        return sportsmanId;
    }

    public void setSportsmanId(Long sportsmanId) {
        this.sportsmanId = sportsmanId;
    }

    public OffsetDateTime getStartRun() {
        return startRun;
    }

    public void setStartRun(OffsetDateTime startRun) {
        this.startRun = startRun;
    }

    public OffsetDateTime getFinishRun() {
        return finishRun;
    }

    public void setFinishRun(OffsetDateTime finishRun) {
        this.finishRun = finishRun;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}   