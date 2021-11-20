package by.kirill.sportsman.app.validation;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.exception.DistanceNotZeroException;
import by.kirill.sportsman.app.exception.StarGreatThanFinisException;
import by.kirill.sportsman.app.model.run.RunRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunValidationService {

    public void validate(final Run run) {
        if (run.getStartRun().toEpochSecond() > run.getFinishRun().toEpochSecond()) {
            throw new StarGreatThanFinisException("Start must be more than Finish");
        }
        if (run.getDistance() < 0) {
            throw new DistanceNotZeroException("Distance must be more that 0 ");
        }
    }

    public void validate(final RunRequest request) {
        if (request.getStartRun().isAfter(request.getFinishRun())) {
            throw new StarGreatThanFinisException("Start run cannot be after end run: " + request);
        }

        if (request.getDistance() <= 0) {
            throw new DistanceNotZeroException(request.getDistance() + "Cannot be negative");
        }
    }
}
