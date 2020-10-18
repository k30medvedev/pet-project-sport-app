package by.kirill.sportsman.app.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "runs")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_run")
    private OffsetDateTime startRun;
    @Column(name = "finish_run")
    private OffsetDateTime finishRun;
    @Column(name = "distance")
    private Double distance;
    @Column(name = "sportsman_id")
    private Long sportsmanId;

    public double getAverage() {
        long dif = finishRun.toEpochSecond() - startRun.toEpochSecond();
        double average = dif / distance;
        return average;
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