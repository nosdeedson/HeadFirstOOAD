package com.E3N.head.first.OOAD.domain.storeinstrument.enumerated;

public enum Style {

    A, F;

    @Override
    public String toString() {
        switch (this){
            case A -> {
                return "a";
            }
            default -> {
                return "b";
            }
        }
    }
}
