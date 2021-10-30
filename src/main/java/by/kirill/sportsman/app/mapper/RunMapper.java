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

    public Run convertDtoToModel(RunRequest dto) {
        Run runEntity = new Run();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(NumberUtil.calculateAverage(runEntity.getStartRun(),runEntity.getFinishRun(),runEntity.getDistance()));
        return runEntity;
    }

    public Run convertDtoToModel(RunUpdateDto dto) {
        Run runEntity = new Run();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(NumberUtil.calculateAverage(runEntity.getStartRun(),runEntity.getFinishRun(),runEntity.getDistance()));
        return runEntity;
    }

    public RunResponse convertModelToDto(Run run, RunResponse runUserDto) {
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
        return runUserDto;
    }

    public void convertModelToDto(Run run, RunUpdateDto runUpdateDto) {
        runUpdateDto.setId(run.getId());
        runUpdateDto.setStartRun(run.getStartRun());
        runUpdateDto.setFinishRun(run.getFinishRun());
        runUpdateDto.setDistance(run.getDistance());
        runUpdateDto.setSportsmanId(run.getSportsmanId());
        runUpdateDto.setAverage(NumberUtil.calculateAverage(run.getStartRun(),run.getFinishRun(),run.getDistance()));
    }

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
                .sportsmanId(source.getSportsmanId())
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
        if (request==null){return null;}

        return Run.builder()
                .startRun(request.getStartRun())
                .finishRun(request.getFinishRun())
                .distance(request.getDistance())
                .average(NumberUtil.calculateAverage(request.getStartRun(),request.getFinishRun(),request.getDistance()))
                .build();
    }
}
