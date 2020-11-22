package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.stereotype.Service;

@Service
public class RunUpdateService {

    private final RunValidationService runValidationService;
    private final RunRepository runRepository;
    private final RunSearchService runSearchService;

    public RunUpdateService(
            RunValidationService runValidationService,
            RunRepository runRepository, RunSearchService runSearchService) {
        this.runValidationService = runValidationService;
        this.runRepository = runRepository;
        this.runSearchService = runSearchService;
    }

    public RunEntity updateRun(Long id, RunEntity runRequest) {
        RunEntity run = runSearchService.findById(id);
        runValidationService.validateRun(run, runRequest);
        run.setStartRun(runRequest.getStartRun());
        run.setFinishRun(runRequest.getFinishRun());
        run.setDistance(runRequest.getDistance());
        run.setAverage(runRequest.getAverage());
        run.setSportsmanId(runRequest.getSportsmanId());
        return runRepository.save(run);
    }
}
