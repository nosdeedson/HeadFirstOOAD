package com.E3N.head.first.OOAD.domain.storeinstrument.instruments;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec.FiddleSpec;

public class Fiddle extends Instrument{
    public Fiddle(String serialNumber, double price, FiddleSpec spec) {
        super(serialNumber, price, spec);
    }

    public Fiddle() {   }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }

}
