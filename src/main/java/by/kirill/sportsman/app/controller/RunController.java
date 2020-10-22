package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.model.Run;
import by.kirill.sportsman.app.service.RunService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class RunController {

    private final RunService runService;

    RunController(RunService runService) {
        this.runService = runService;
    }

//    @GetMapping("/runs")
//    @ResponseBody
//    RunsListDto getAllRuns() {
//        RunsListDto runsListDto = new RunsListDto();
//        List<Run> runs = runService.findAllRuns();
//        runsListDto.setRuns(runs);
//        return runsListDto;
//    }

    @GetMapping("/runs")
    @ResponseBody

    RunsListDto getAllRuns(){
        List<RunUserDto> dtoList = new ArrayList<RunUserDto>();
        List<Run> runList = runService.findAllRuns();
        RunsListDto runsListDto = new RunsListDto();
//        dtoList = runList.stream().map(dtoList-> mvcConversionService.convert )

        return runsListDto;


    }


//    RunsListDto getAllRuns(@RequestBody RunUserDto runUserDto) {
//        RunsListDto runsListDto = new RunsListDto();
//
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.map(runList,runsListDto);
//        TypeMap<Run, RunUserDto> typeMap = modelMapper.typeMap(Run.class,RunUserDto.class).addMapping(Run::getId,RunUserDto::setId);
//




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
    RunDeleteDto deleteRun(@PathVariable Long id) {
        RunDeleteDto dto = new RunDeleteDto();
        Run run = runService.findById(id);
        dto.setId(run.getId());
        runService.deleteById(id);
        return dto;
    }

}