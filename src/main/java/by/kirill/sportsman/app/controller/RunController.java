package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.service.RunService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
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
        List<RunEntity> runList = runService.findAllRuns();
        Type listType = new TypeToken<List<RunUserDto>>() {
        }.getType();
        List<RunUserDto> dtoList = new ModelMapper().map(runList, listType);
        runsListDto.setRuns(dtoList);
        return runsListDto;
    }

    @PostMapping("/runs")
    RunUserDto createRun(@RequestBody RunCreationDto dto) {
        RunEntity run = convertDtoToModel(dto);
        run = runService.saveRun(run);
        RunUserDto runUserDto = new RunUserDto();
        ConvertUserDtoToRun(run, runUserDto);
        return runUserDto;
    }

//    @PutMapping("/runs/{id}")
//    RunUserDto updateRun(@PathVariable Long id, @RequestBody RunCreationDto dto) {
//        RunEntity run = runService.findById(id);
//        convertDtoToModel(dto, run);
//        run = runService.saveRun(run);
//        RunUserDto runUserDto = new RunUserDto();
//        ConvertUserDtoToRun(run, runUserDto);
//        return runUserDto;
//    }

    @ResponseBody
    @DeleteMapping("/runs/{id}")
    RunDeleteDto deleteRun(@PathVariable Long id) {
        RunDeleteDto dto = new RunDeleteDto();
        RunEntity run = runService.findById(id);
        dto.setId(run.getId());
        runService.deleteById(id);
        return dto;
    }

    private RunEntity convertDtoToModel(RunCreationDto dto) {
        RunEntity run = new RunEntity();
        run.setStartRun(dto.getStartRun());
        run.setFinishRun(dto.getFinishRun());
        run.setDistance(dto.getDistance());
        run.setSportsmanId(dto.getSportsmanId());
        run.setAverage(run.calculateAverage());
        return run;
    }


    private void ConvertUserDtoToRun(RunEntity run, RunUserDto runUserDto) {
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.calculateAverage());
    }
  // переделать!
    // перенести методы в отдельный класс.
}