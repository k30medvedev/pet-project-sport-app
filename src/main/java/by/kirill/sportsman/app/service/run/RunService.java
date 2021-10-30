package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.exception.RunNotFoundException;
import by.kirill.sportsman.app.mapper.RunMapper;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.repository.RunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RunService {

    private final RunRepository runRepository;
    private final RunSearchService runSearchService;

    private final RunUpdateService runUpdateService;
    private final RunCreateRunService runCreateRunService;

    private final RunMapper mapper;

    public RunResponse createRun(final RunRequest request) {
        final Run run = mapper.mapTo(request);
        return mapper.map(runRepository.save(run));
    }

    public RunResponse deleteById(Long id) {
        Run run = findOneOrThrowException(id);
        runRepository.deleteById(id);
        return mapper.map(run);
    }

    public Run updateRun(Long id, RunRequest request) {
        final Run run = findOneOrThrowException(id);

        return runUpdateService.updateRun(id, runEntity);
    }

    public List<RunResponse> getAllRuns() {
        return mapper.map(runRepository.findAll());
    }

    public RunResponse getRun(final Long id) {
        return mapper.map(findOneOrThrowException(id));
    }

    public Run findOneOrThrowException(final Long id) {
        return runRepository.findById(id).orElseThrow(() -> new RunNotFoundException(id + "Not found"));
    }
}
