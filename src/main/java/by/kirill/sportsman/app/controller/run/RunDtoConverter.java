package by.kirill.sportsman.app.controller.run;

import by.kirill.sportsman.app.model.RunEntity;
import org.springframework.stereotype.Component;


@Component
public class RunDtoConverter {


    public RunEntity convertDtoToModel(RunCreationDto dto) {
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(runEntity.calculateAverage());
        return runEntity;
    }

    public RunEntity convertDtoToModel(RunUpdateDto dto) {
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(runEntity.calculateAverage());
        return runEntity;
    }

    public RunUserDto convertModelToDto(RunEntity run, RunUserDto runUserDto) {
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
        return runUserDto;
    }

    public void convertModelToDto(RunEntity run, RunUpdateDto runUpdateDto) {
        runUpdateDto.setId(run.getId());
        runUpdateDto.setStartRun(run.getStartRun());
        runUpdateDto.setFinishRun(run.getFinishRun());
        runUpdateDto.setDistance(run.getDistance());
        runUpdateDto.setSportsmanId(run.getSportsmanId());
        runUpdateDto.setAverage(run.calculateAverage());
    }

}
