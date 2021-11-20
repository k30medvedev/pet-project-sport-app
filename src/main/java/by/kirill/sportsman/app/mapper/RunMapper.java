package by.kirill.sportsman.app.mapper;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.model.run.RunUpdateDto;
import by.kirill.sportsman.app.util.NumberUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class RunMapper {

    public RunResponse map(Run source) {
        if (source == null) {
            return null;
        }
        return RunResponse.builder()
                .id(source.getId())
                .startRun(source.getStartRun())
                .finishRun(source.getFinishRun())
                .distance(source.getDistance())
                .average(source.getAverage())
                .sportsmanId(source.getId())
                .build();
    }

    public List<RunResponse> map(List<Run> source) {
        return Optional.ofNullable(source)
                .orElseGet(ArrayList::new)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Run mapTo(RunRequest request) {
        if (request == null) {
            return null;
        }
        return Run.builder()
                .startRun(request.getStartRun())
                .finishRun(request.getFinishRun())
                .distance(request.getDistance())
                .average(NumberUtil.calculateAverage(request.getStartRun(), request.getFinishRun(), request.getDistance()))
                .sportsmanId(request.getSportsmanId())
                .build();
    }

    public Run map(RunRequest request, Run run) {
        return Run.builder()
                .id(run.getId())
                .startRun(request.getStartRun())
                .finishRun(request.getFinishRun())
                .distance(request.getDistance())
                .average(NumberUtil.calculateAverage(request.getStartRun(), request.getFinishRun(), request.getDistance()))
                .build();
    }

}
