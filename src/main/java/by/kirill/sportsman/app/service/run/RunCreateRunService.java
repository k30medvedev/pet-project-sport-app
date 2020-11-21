package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.stereotype.Service;

@Service
public class RunCreateRunService {
    private final RunValidationService runValidationService;
    private final RunRepository runRepository;

    public RunCreateRunService(RunValidationService runValidationService,
                               RunRepository runRepository) {
        this.runValidationService = runValidationService;
        this.runRepository = runRepository;
    }


    public RunEntity createRun(RunEntity run) throws StarGreatThanFinisException, DistanceNotZeroException {
        runValidationService.validateRun(run);
        run.setId(null);
        return runRepository.save(run);
    }
}
