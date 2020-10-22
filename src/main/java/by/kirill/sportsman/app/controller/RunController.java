package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.service.RunService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
class RunController {

    private final RunService runService;

    RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping("/runs")
    @ResponseBody
    RunsListDto getAllRuns() {
        RunsListDto runsListDto = new RunsListDto();
        List<Run> runList = runService.findAllRuns();
        Type listType = new TypeToken<List<RunUserDto>>() {
        }.getType();
        List<RunUserDto> dtoList = new ModelMapper().map(runList, listType);
        runsListDto.setRuns(dtoList);
        return runsListDto;
    }

    @PostMapping("/runs")
    RunUserDto createRun(@RequestBody RunCreationDto dto) {
        Run run = new Run();
        ConvertRunToDto(dto, run);
        run = runService.saveRun(run);
        RunUserDto runUserDto = new RunUserDto();
        ConvertUserDtoToRun(run, runUserDto);
        return runUserDto;
    }

    @PutMapping("/runs/{id}")
    RunUserDto updateRun(@PathVariable Long id, @RequestBody RunCreationDto dto) {
        Run run = runService.findById(id);
        ConvertRunToDto(dto, run);
        run = runService.saveRun(run);
        RunUserDto runUserDto = new RunUserDto();
        ConvertUserDtoToRun(run, runUserDto);
        return runUserDto;
    }

    @ResponseBody
    @DeleteMapping("/runs/{id}")
    RunDeleteDto deleteRun(@PathVariable Long id) {
        RunDeleteDto dto = new RunDeleteDto();
        Run run = runService.findById(id);
        dto.setId(run.getId());
        runService.deleteById(id);
        return dto;
    }

    private void ConvertRunToDto(@RequestBody RunCreationDto dto, Run run) {
        run.setStartRun(dto.getStartRun());
        run.setFinishRun(dto.getFinishRun());
        run.setDistance(dto.getDistance());
        run.setSportsmanId(dto.getSportsmanId());
    }

    private void ConvertUserDtoToRun(Run run, RunUserDto runUserDto) {
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
    }


}