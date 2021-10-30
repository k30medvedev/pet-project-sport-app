package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.repository.RunRepository;
import by.kirill.sportsman.app.validation.RunValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunUpdateService {

    private final RunValidationService runValidationService;
    private final RunRepository runRepository;
    private final RunSearchService runSearchService;

    public Run updateRun(Long id, Run runRequest) {
        Run run = runSearchService.findById(id);
        runValidationService.validateRun(run, runRequest);
        run.setStartRun(runRequest.getStartRun());
        run.setFinishRun(runRequest.getFinishRun());
        run.setDistance(runRequest.getDistance());
        run.setAverage(runRequest.getAverage());
        run.setSportsmanId(runRequest.getSportsmanId());
        return runRepository.save(run);
    }
}
