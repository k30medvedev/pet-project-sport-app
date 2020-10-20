package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.service.RunService;
import org.springframework.web.bind.annotation.*;

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
        List<Run> runs = runService.findAllRuns();
        runsListDto.setRuns(runs);
        return runsListDto;
    }


    @PutMapping("/runs/{id}")
    RunUserDto updateRun(@PathVariable Long id, @RequestBody RunUpdateDto runUpdateDto) {
        Run run = runService.findById(id);
        run.setStartRun(runUpdateDto.getStartRun());
        run.setFinishRun(runUpdateDto.getFinishRun());
        run.setDistance(runUpdateDto.getDistance());
        run.setSportsmanId(runUpdateDto.getSportsmanId());
        run = runService.saveRun(run);
        RunUserDto runUserDto = new RunUserDto();
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
        return runUserDto;

    }

    @PostMapping("/runs")
    RunUserDto createRun(@RequestBody RunCreationDto dto) {

        Run run = new Run();
        run.setStartRun(dto.getStartRun());
        run.setFinishRun(dto.getFinishRun());
        run.setDistance(dto.getDistance());
        run.setSportsmanId(dto.getSportsmanId());
        run = runService.saveRun(run);
        RunUserDto runUserDto = new RunUserDto();
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
        return runUserDto;
    }


    @ResponseBody
    @DeleteMapping("/runs/{id}")
    Long deleteRun(@PathVariable Long id) {
        runService.deleteById(id);
        return id;
    }
// Вернуть JSON  с ID либо void ResponseStatus (HTTP 204 No content)

}