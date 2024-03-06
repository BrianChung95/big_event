package com.brian.anno;

import com.brian.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@Documented

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = { StateValidation.class }
)

public @interface State {
    String message() default "State can only be Published or Draft";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
