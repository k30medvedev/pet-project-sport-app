package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.stereotype.Service;

@Service
public class RunUpdateRun
{
    private final RunSearchService runSearchService;
    private final RunValidationService runValidationService;
    private final RunRepository runRepository;

    public RunUpdateRun(RunSearchService runSearchService,
                        RunValidationService runValidationService,
                        RunRepository runRepository) {
        this.runSearchService = runSearchService;
        this.runValidationService = runValidationService;
        this.runRepository = runRepository;
    }


    public RunEntity updateRun(Long id, RunEntity runEntity) {
        RunEntity run = runSearchService.findById(id);
        runValidationService.validateRun(run, runEntity);
        run.setStartRun(runEntity.getStartRun());
        run.setFinishRun(runEntity.getFinishRun());
        run.setDistance(runEntity.getDistance());
        run.setAverage(runEntity.getAverage());
        run.setSportsmanId(runEntity.getSportsmanId());
        return runRepository.save(run);
    }

}
