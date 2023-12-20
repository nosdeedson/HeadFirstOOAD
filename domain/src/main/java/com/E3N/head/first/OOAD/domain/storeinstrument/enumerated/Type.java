package com.E3N.head.first.OOAD.domain.storeinstrument.enumerated;

public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this){
            case ACOUSTIC -> {
                return  "Acoustic";
            }
            case ELECTRIC -> {
                return "Electric";
            }
            default -> {
                return "error";
            }
        }
    }
}
