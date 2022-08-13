package by.kirill.sportsman.app.validation;

import by.kirill.sportsman.app.model.run.RunRequest;

public interface RunValidationService {
    void validate(final RunRequest request);
}
