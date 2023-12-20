package com.E3N.head.first.OOAD.domain.v2.storeinstrument.validator;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error error);
    ValidationHandler append(ValidationHandler handler);
    <T> T validate(Validation<T> validation);

    List<Error> getErros();

    default boolean hasErro(){
        return getErros() != null && !getErros().isEmpty();
    }

    default Error firstErro(){
        if(getErros() != null && !getErros().isEmpty()){
            return getErros().get(0);
        }else {
            return null;
        }
    }

    interface Validation<T>{
        T validate();
    }
}
