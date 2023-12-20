package com.E3N.head.first.OOAD.domain.v2.storeinstrument.validator.handler;

import com.E3N.head.first.OOAD.domain.v2.storeinstrument.validator.Error;
import com.E3N.head.first.OOAD.domain.v2.storeinstrument.validator.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {
    private final List<Error> erros;

    private Notification(final List<Error> errors){
        this.erros = errors;
    }

    public static Notification create(){
        return new Notification(new ArrayList<>());
    }

    public static Notification create(Throwable t){
        return create(new Error(t.getMessage()));
    }

    public static Notification create(final Error error){
        return (Notification) new Notification(new ArrayList<>()).append(error);
    }

    @Override
    public ValidationHandler append(Error error) {
        this.erros.add(error);
        return this;
    }

    @Override
    public ValidationHandler append(ValidationHandler handler) {
        this.erros.addAll(handler.getErros());
        return this;
    }

    @Override
    public <T> T validate(Validation<T> validation) {
        try {
            return validation.validate();
        }catch (Throwable t){
            this.erros.add(new Error(t.getMessage()));
        }
        return null;
    }

    @Override
    public List<Error> getErros() {
        return this.erros;
    }
}
