package com.mx.serti.util.singletons;

import com.mx.serti.exceptions.BadRequestException;
import com.mx.serti.util.constants.ErrorMessages;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SingletonValidatorConstraint {

    public static final SingletonValidatorConstraint instance = new SingletonValidatorConstraint();

    public static SingletonValidatorConstraint getInstance() {
        return instance;
    }

    public <T> void validate(T genericDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations;
        violations = validator.validate(genericDTO);
        StringBuilder errorMessage = new StringBuilder();

        boolean containError = false;
        for (ConstraintViolation<?> violation : violations) {
            containError = true;
            errorMessage.append(violation.getMessage() + ", ");
        }
        if (errorMessage.length() > 0) {
            errorMessage = new StringBuilder(errorMessage.substring(0, errorMessage.length() - 2));
        }
        if (containError) {
            throw new BadRequestException(ErrorMessages.VALUES_NULL + errorMessage);
        }
    }

}
