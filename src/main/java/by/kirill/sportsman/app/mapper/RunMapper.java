package by.kirill.sportsman.app.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.util.NumberUtil;

@Component
public class RunMapper {

    public RunResponse map(final Run source) {
        return Optional.ofNullable(source)
                .map(value -> RunResponse.builder()
                        .id(value.getId())
                        .startRun(value.getStartRun())
                        .finishRun(value.getFinishRun())
                        .distance(value.getDistance())
                        .average(value.getAverage())
                        .sportsmanId(value.getId())
                        .build())
                .orElse(null);
    }

    public List<RunResponse> map(final List<Run> source) {
        return Optional.ofNullable(source)
                .orElseGet(ArrayList::new)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Run mapTo(final RunRequest request) {
        if (request == null) {
            return null;
        }
        return Run.builder()
                .startRun(request.getStartRun())
                .finishRun(request.getFinishRun())
                .distance(request.getDistance())
                .average(NumberUtil.calculateAverage(request.getStartRun(), request.getFinishRun(),
                        request.getDistance()))
                .sportsmanId(request.getSportsmanId())
                .build();
    }

    public Run map(final RunRequest request, Run run) {
        return Run.builder()
                .id(run.getId())
                .startRun(request.getStartRun())
                .finishRun(request.getFinishRun())
                .distance(request.getDistance())
                .average(NumberUtil.calculateAverage(request.getStartRun(), request.getFinishRun(),
                        request.getDistance()))
                .build();
    }

}
