package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.exception.DistanceNotZeroException;
import by.kirill.sportsman.app.exception.StarGreatThanFinisException;
import by.kirill.sportsman.app.repository.RunRepository;
import by.kirill.sportsman.app.validation.RunValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunCreateRunService {
    private final RunValidationService runValidationService;
    private final RunRepository runRepository;

    public Run createRun(Run run) throws StarGreatThanFinisException, DistanceNotZeroException {
        runValidationService.validate(run);
        run.setId(null);
        return runRepository.save(run);
    }
}
