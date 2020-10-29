package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RunService {

    private final RunRepository runRepository;
    private final RunValidationService runValidationService;

    public RunService(RunRepository runRepository, RunValidationService runValidationService) {

        this.runRepository = runRepository;
        this.runValidationService = runValidationService;
    }

    public RunEntity findById(Long id) {
        return runRepository.getOne(id);
    }

    public List<RunEntity> findAllRuns() {
        return runRepository.findAll();
    }

    public RunEntity saveRun(RunEntity run) throws StarGreatThanFinisException {
        runValidationService.validateRun(run);
        run.setId(null);
        return runRepository.save(run);
    }

    public void deleteById(Long id) {
        runRepository.deleteById(id);
    }

    public RunEntity updateRun(Long id, RunEntity runEntity) {
        RunEntity run = findById(id);
        runValidationService.validateRun(run,runEntity);
        run.setStartRun(runEntity.getStartRun());
        run.setFinishRun(runEntity.getFinishRun());
        run.setDistance(runEntity.getDistance());
        run.setAverage(runEntity.getAverage());
        run.setSportsmanId(runEntity.getSportsmanId());
        return runRepository.save(run);
    }
}
