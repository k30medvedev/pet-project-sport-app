package by.kirill.sportsman.app.validation;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.exception.DistanceNotZeroException;
import by.kirill.sportsman.app.exception.StarGreatThanFinisException;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class RunValidationService {

    public void validateRun(@Valid Run run) throws StarGreatThanFinisException, DistanceNotZeroException {
        if (run.getStartRun().toEpochSecond() > run.getFinishRun().toEpochSecond()) {
            throw new StarGreatThanFinisException("Start must be more than Finish");
        }
        if (run.getDistance() < 0) {
            throw new DistanceNotZeroException("Distance must be more that 0 ");
        }
    }

    public void validateRun(@Valid @NotNull Run run, @Valid Run runEntity) {

    }
}
