package com.E3N.head.first.OOAD.domain.storeinstrument.tuner;

import com.E3N.head.first.OOAD.domain.storeinstrument.instruments.Instrument;

public class Tuner {

    private Instrument instrument;

    public Tuner(Instrument instrument) {
        this.instrument = instrument;
    }

    public String tunning(){
        return this.instrument.tune();
    }
}
