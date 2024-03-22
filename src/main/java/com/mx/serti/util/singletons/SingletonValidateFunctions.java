package com.mx.serti.util.singletons;

import com.mx.serti.exceptions.BadRequestException;
import com.mx.serti.util.constants.ErrorMessages;

import java.util.Objects;

public class SingletonValidateFunctions {

    public static final SingletonValidateFunctions instance = new SingletonValidateFunctions();

    public static SingletonValidateFunctions getInstance() {
        return instance;
    }

    public void nullId(Long id) {
        if (Objects.isNull(id)) {
            String errorMessage = ErrorMessages.ID_NULL;
            throw new BadRequestException(errorMessage);
        }
    }

    public void idsMissmtachs(Long id, Long idObject) {
        if (!id.equals(idObject)) {
            String errorMessage = String.format(ErrorMessages.ID_MISSMATCHS, id, idObject);
            throw new BadRequestException(errorMessage);
        }
    }

}
