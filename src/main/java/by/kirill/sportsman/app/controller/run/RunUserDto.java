package by.kirill.sportsman.app.controller.run;

import java.time.OffsetDateTime;

public class RunUserDto {
    private Long id;
    private OffsetDateTime startRun;
    private OffsetDateTime finishRun;
    private Double distance;
    private Double average ;
    private Long sportsmanId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
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
}
