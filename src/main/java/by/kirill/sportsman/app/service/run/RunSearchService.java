package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.repository.RunRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunSearchService {
     private final RunRepository runRepository;

    public RunSearchService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public Run findById(Long id) {
        return runRepository.getOne(id);
    }

    public List<Run> findAllRuns() {
        return runRepository.findAll();
    }
}
