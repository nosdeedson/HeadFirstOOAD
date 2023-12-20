package com.E3N.head.first.OOAD.domain.v2.storeinstrument.validator;



public abstract class Validator {
    private final ValidationHandler handler;

    protected Validator(ValidationHandler handler) {
        this.handler = handler;
    }

    public abstract void validate();

    protected ValidationHandler validationHandler(){
        return this.handler;
    }
}
