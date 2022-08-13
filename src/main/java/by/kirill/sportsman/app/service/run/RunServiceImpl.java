package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.exception.RunNotFoundException;
import by.kirill.sportsman.app.mapper.RunMapper;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.repository.RunRepository;
import by.kirill.sportsman.app.validation.RunValidationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RunServiceImpl implements RunService {

    private final RunRepository runRepository;
    private final RunMapper mapper;

    private final RunValidationServiceImpl validator;

    public RunResponse createRun(final RunRequest request) {
        final var run = mapper.mapTo(request);
        return mapper.map(runRepository.save(run));
    }

    public RunResponse deleteRunById(final Long id) {
        final var run = findOneOrThrowException(id);
        runRepository.deleteById(id);
        return mapper.map(run);
    }

    public RunResponse updateRun(final Long id, final RunRequest request) {
        validator.validate(request);
        final var run = findOneOrThrowException(id);
        final var exist = mapper.map(request, run);
        return mapper.map(runRepository.save(exist));
    }

    public List<RunResponse> findAllRuns() {
        return mapper.map(runRepository.findAll());
    }

    public RunResponse findRun(final Long id) {
        return mapper.map(findOneOrThrowException(id));
    }

    private Run findOneOrThrowException(final Long id) {
        return runRepository.findById(id)
                .orElseThrow(() -> new RunNotFoundException(id + "Not found"));
    }
}
