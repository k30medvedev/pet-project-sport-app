package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.RunEntity;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Service

public class RunValidationService {

    void validateRun(@Valid RunEntity run) throws StarGreatThanFinisException {
        if (run.getStartRun().toEpochSecond() > run.getFinishRun().toEpochSecond()) {
            throw new StarGreatThanFinisException("Start must be more than Finish");
        }
        if (run.getDistance() < 0) {
            throw new DistanceNotZeroException("Distance must be more that 0 ");
        }
    }

    public void validateRun(@Valid @NotNull RunEntity run, @Valid RunEntity runEntity) {
    }
}
