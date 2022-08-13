package by.kirill.sportsman.app.service.run;

import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;

import java.util.List;

public interface RunService {

    RunResponse createRun(final RunRequest request);

    RunResponse deleteRunById(final Long id);

    RunResponse updateRun(final Long id, final RunRequest request);

    List<RunResponse> findAllRuns();

    RunResponse findRun(final Long id);

}
