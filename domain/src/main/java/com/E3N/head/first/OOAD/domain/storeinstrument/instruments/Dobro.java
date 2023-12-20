package com.E3N.head.first.OOAD.domain.storeinstrument.instruments;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec.InstrumentSpec;

public class Dobro extends Instrument{
    public Dobro(String serialNumber, double price, InstrumentSpec spec) {
        super(serialNumber, price, spec);
    }

    public Dobro() {   }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
