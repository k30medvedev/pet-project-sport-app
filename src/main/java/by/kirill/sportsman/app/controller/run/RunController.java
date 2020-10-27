package by.kirill.sportsman.app.controller.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.service.RunService;
import by.kirill.sportsman.app.service.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
class RunController {

    private final ModelMapper modelMapper;
    private final RunService runService;
    private final Converter converter;

    RunController(ModelMapper modelMapper, RunService runService, Converter converterDto) {
        this.modelMapper = modelMapper;
        this.runService = runService;
        this.converter = converterDto;
    }

    @GetMapping("/runs")
    @ResponseBody
    RunsListDto getAllRuns() {
        RunsListDto runsListDto = new RunsListDto();
        List<RunEntity> runList = runService.findAllRuns();
        Type listType = new TypeToken<List<RunUserDto>>() {
        }.getType();
        List<RunUserDto> dtoList = modelMapper.map(runList, listType);
        runsListDto.setRuns(dtoList);
        return runsListDto;
    } // конвертер,метод.

    @PostMapping("/runs")
    RunUserDto createRun(@RequestBody RunCreationDto dto) {
        RunEntity runEntity = converter.convertDtoToModel(dto);
        runEntity = runService.saveRun(runEntity);
        RunUserDto runUserDto = new RunUserDto();
        runUserDto = converter.convertModelToDto(runEntity, runUserDto);
        return runUserDto;
    }

    @PutMapping("/runs/{id}")
    RunUpdateDto updateRun(@PathVariable Long id, @RequestBody RunUpdateDto dto) {
        RunEntity runEntity = converter.convertDtoToModel(dto);
        runService.updateRun(id, runEntity);
        RunUpdateDto runUpdateDto = new RunUpdateDto();
        converter.convertModelToDto(runEntity, runUpdateDto);
        return runUpdateDto;
    }

    @ResponseBody
    @DeleteMapping("/runs/{id}")
    RunDeleteDto deleteRun(@PathVariable Long id) {
        RunDeleteDto dto = new RunDeleteDto();
        RunEntity run = runService.findById(id);
        dto.setId(run.getId());
        runService.deleteById(id);
        return dto;
    }


}