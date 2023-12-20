package com.E3N.head.first.OOAD.domain.storeinstrument.instruments;

import com.E3N.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import com.E3N.head.first.OOAD.domain.storeinstrument.instrumentspec.BanjoSpec;

public class Banjo extends Instrument{
    public Banjo(String serialNumber, double price, BanjoSpec spec) {
        super(serialNumber, price, spec);
    }

    public Banjo() {    }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
