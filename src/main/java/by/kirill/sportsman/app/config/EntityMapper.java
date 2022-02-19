package by.kirill.sportsman.app.config;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import by.kirill.sportsman.app.domain.Run;
import by.kirill.sportsman.app.domain.User;
import by.kirill.sportsman.app.model.run.RunRequest;
import by.kirill.sportsman.app.model.run.RunResponse;
import by.kirill.sportsman.app.model.user.UserCreationRequest;
import by.kirill.sportsman.app.model.user.UserResponse;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    RunResponse map(final Run run);

    Run map(final RunRequest request);

    User map(final UserCreationRequest request);

    UserResponse map(final User source);

}
