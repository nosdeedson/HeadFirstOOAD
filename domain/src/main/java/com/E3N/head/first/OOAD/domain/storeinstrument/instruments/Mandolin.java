package com.E3N.head.first.OOAD.domain.storeinstrument.instruments;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec.MandolinSpec;

public class Mandolin extends Instrument{

    public Mandolin(String serialNumber, double price, MandolinSpec spec) {
        super(serialNumber, price, spec);
    }

    public Mandolin() {   }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
