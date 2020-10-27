package by.kirill.sportsman.app.validation;


import org.hibernate.annotations.Parameter;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Constraint(validatedBy = RunValidate.class)
@Target(ElementType.PARAMETER)

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateStartFinish {

    String message() default
            "finishRun must be great than startRun";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

