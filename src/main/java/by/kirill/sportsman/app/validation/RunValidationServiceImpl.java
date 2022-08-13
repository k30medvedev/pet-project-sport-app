package by.kirill.sportsman.app.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.exception.DistanceNotZeroException;
import by.kirill.sportsman.app.exception.StarGreatThanFinisException;
import by.kirill.sportsman.app.model.run.RunRequest;

@Service
@Validated
public class RunValidationServiceImpl implements RunValidationService {

    public void validate(final RunRequest request) {
        if (request.getStartRun()
                .isAfter(request.getFinishRun())) {
            throw new StarGreatThanFinisException("Start run cannot be after end run: " + request);
        }

        if (request.getDistance() <= 0) {
            throw new DistanceNotZeroException(request.getDistance() + "Cannot be negative");
        }
    }
}
