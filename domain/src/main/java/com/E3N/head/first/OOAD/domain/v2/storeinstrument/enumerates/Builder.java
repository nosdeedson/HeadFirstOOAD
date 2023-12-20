package com.E3N.head.first.OOAD.domain.v2.storeinstrument.enumerates;

public enum Builder {

    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    @Override
    public String toString() {
        switch (this){
            case FENDER -> {
                return "Fender";
            }
            case MARTIN -> {
                return "Martin";
            }
            case GIBSON -> {
                return "Gibson";
            }
            case COLLINGS -> {
                return "Collings";
            }
            case OLSON -> {
                return "Olso";
            }
            case RYAN -> {
                return "Ryan";
            }
            case PRS -> {
                return "prs";
            }
            default -> {
                return "Any";
            }
        }
    }
}
