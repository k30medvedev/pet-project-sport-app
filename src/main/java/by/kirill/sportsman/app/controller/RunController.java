package by.kirill.sportsman.app.controller;

import by.kirill.sportsman.app.config.swagger.run.*;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.service.run.RunServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/runs")
class RunController {

    private final RunServiceImpl runServiceImpl;

    @GetMapping
    @GetRunsOperation
    public ResponseEntity<List<RunResponse>> findAllRuns() {
        return ResponseEntity.ok(runServiceImpl.findAllRuns());
    }

    @GetMapping("/{id}")
    @GetRunOperation
    public ResponseEntity<RunResponse> findRun(@PathVariable @Valid @Min(1) @Max(Integer.MAX_VALUE) final Long id) {
        return ResponseEntity.ok(runServiceImpl.findRun(id));
    }

    @PostMapping
    @CreateRunOperation
    public ResponseEntity<RunResponse> createRun(@Valid final RunRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(runServiceImpl.createRun(request));
    }

    @PutMapping("/{id}")
    @UpdateRunOperation
    public ResponseEntity<RunResponse> updateRun(@PathVariable @Valid @Min(1) @Max(Integer.MAX_VALUE) final Long id,
            @Valid final RunRequest request) {
        return ResponseEntity.accepted()
                .body(runServiceImpl.updateRun(id, request));
    }

    @DeleteMapping("/{id}")
    @DeleteRunOperation
    public ResponseEntity<RunResponse> deleteRun(@PathVariable @Valid @Min(1) @Max(Integer.MAX_VALUE) final Long id) {
        return ResponseEntity.accepted()
                .body(runServiceImpl.deleteRunById(id));
    }

}