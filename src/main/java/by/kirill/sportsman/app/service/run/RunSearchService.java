package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunSearchService {
     private final RunRepository runRepository;

    public RunSearchService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public RunEntity findById(Long id) {
        return runRepository.getOne(id);
    }

    public List<RunEntity> findAllRuns() {
        return runRepository.findAll();
    }
}
