package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.config.swagger.*;
import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.service.run.RunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/runs")
class RunController {

    private final RunService runService;

    @GetMapping
    @GetRunsOperationOperation
    public ResponseEntity<List<RunResponse>> getAllRuns() {
        return ResponseEntity.ok(runService.getAllRuns());
    }

    @GetMapping("/{id}")
    @GetRunOperationOperation
    public ResponseEntity<RunResponse> getRun(@PathVariable @Valid @Min(1)
                                              @Max(Integer.MAX_VALUE) final Long id) {
        return ResponseEntity.ok(runService.getRun(id));
    }

    @PostMapping
    @CreateRunOperationOperation
    public ResponseEntity<RunResponse> createRun(@RequestBody final RunRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(runService.createRun(request));
    }

    @PutMapping("/{id}")
    @UpdateRunOperationOperation
    public ResponseEntity<RunResponse> updateRun(@PathVariable @Valid @Min(1)
                                                 @Max(Integer.MAX_VALUE) final Long id, @RequestBody final RunRequest request) {
        return ResponseEntity.accepted().body(runService.updateRun(id, request));
    }

    @DeleteMapping("/{id}")
    @DeleteRunOperationOperation
    public ResponseEntity<RunResponse> deleteRun(@PathVariable @Valid @Min(1)
                                                 @Max(Integer.MAX_VALUE) final Long id) {
            return ResponseEntity.accepted().body(runService.deleteById(id));
    }

}