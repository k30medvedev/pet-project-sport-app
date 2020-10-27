package by.kirill.sportsman.app.service;

import by.kirill.sportsman.app.controller.run.RunCreationDto;
import by.kirill.sportsman.app.controller.run.RunUpdateDto;
import by.kirill.sportsman.app.controller.run.RunUserDto;
import by.kirill.sportsman.app.controller.user.UserCreationDto;
import by.kirill.sportsman.app.controller.user.UserDto;
import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public RunEntity convertDtoToModel(RunCreationDto dto) {
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(runEntity.calculateAverage());
        return runEntity;
    }
    public RunEntity convertDtoToModel(RunUpdateDto dto) {
        RunEntity runEntity = new RunEntity();
        runEntity.setStartRun(dto.getStartRun());
        runEntity.setFinishRun(dto.getFinishRun());
        runEntity.setDistance(dto.getDistance());
        runEntity.setSportsmanId(dto.getSportsmanId());
        runEntity.setAverage(runEntity.calculateAverage());
        return runEntity;
    }
    public RunUserDto convertModelToDto(RunEntity run, RunUserDto runUserDto) {
        runUserDto.setId(run.getId());
        runUserDto.setStartRun(run.getStartRun());
        runUserDto.setFinishRun(run.getFinishRun());
        runUserDto.setDistance(run.getDistance());
        runUserDto.setSportsmanId(run.getSportsmanId());
        runUserDto.setAverage(run.getAverage());
        return runUserDto;
    }
    public void convertModelToDto(RunEntity run, RunUpdateDto runUpdateDto) {
        runUpdateDto.setId(run.getId());
        runUpdateDto.setStartRun(run.getStartRun());
        runUpdateDto.setFinishRun(run.getFinishRun());
        runUpdateDto.setDistance(run.getDistance());
        runUpdateDto.setSportsmanId(run.getSportsmanId());
        runUpdateDto.setAverage(run.calculateAverage());
    }

    public void convertDtoToUser(UserEntity user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());
    }
    public UserEntity convertDtoToUser(UserCreationDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setBirthday(dto.getBirthday());
        return userEntity;
    }
    public UserDto convertUserToDto(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setEmail(userEntity.getEmail());
        dto.setBirthday(userEntity.getBirthday());
        return dto;
    }
}

// можно разделить на 2 класса.
// переименовать оба класса
// Перенести в Контроллереры.

