package com.brian.validation;

import com.brian.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {
    /**
     *
     * @param s Data that will be evaluated.
     * @param constraintValidatorContext context in which the constraint is evaluated.
     * @return Data is validated or not
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;

        return s.equals("Draft") || s.equals("Published");
    }
}
