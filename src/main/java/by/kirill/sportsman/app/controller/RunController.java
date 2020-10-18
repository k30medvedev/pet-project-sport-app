package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.model.User;
import by.kirill.sportsman.app.repository.RunRepository;
import by.kirill.sportsman.app.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }


    @RequestMapping("/run")
    String index() {
        return "Runs";
    }

    @GetMapping("/runs")
    @ResponseBody
    RunsListDto getAllRuns() {
        RunsListDto runsListDto = new RunsListDto();
        List<Run> runs = runService.findAllRuns();
        runsListDto.setRuns(runs);
        return runsListDto;
    }

    @ResponseBody
    @DeleteMapping("/runs/{id}")
    Long deleteRun(@PathVariable Long id) {
        runService.deleteById(id);
        return id;
    }


//    @PutMapping("/runs/{id}")
//    Run updateRun(@RequestBody Run run) {
//        runService.saveRun(run);
//        return run;
//
//    }

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

}