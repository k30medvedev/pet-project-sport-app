package by.kirill.sportsman.app.validation;

import by.kirill.sportsman.app.model.RunEntity;
import by.kirill.sportsman.app.model.UserEntity;
import by.kirill.sportsman.app.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class RunValidate implements ConstraintValidator<ValidateStartFinish, RunEntity> {


    @Override
    public void initialize(ValidateStartFinish constraintAnnotation) {

    }

    @Override
    public boolean isValid(RunEntity runEntity, ConstraintValidatorContext constraintValidatorContext) {
        if (runEntity.getFinishRun().isAfter(runEntity.getFinishRun())) {
            //runEntity.getStartRun().toEpochSecond() < runEntity.getFinishRun().toEpochSecond()) {

            return true;
        }

        return false;
    }
}
