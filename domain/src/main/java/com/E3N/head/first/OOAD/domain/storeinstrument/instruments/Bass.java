package com.E3N.head.first.OOAD.domain.storeinstrument.instruments;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec.InstrumentSpec;

public class Bass extends Instrument{

    public Bass(String serialNumber, double price, InstrumentSpec spec) {
        super(serialNumber, price, spec);
    }

    public Bass() {  }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
