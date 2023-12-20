package com.E3N.head.first.OOAD.domain.v2.storeinstrument.instruments;

import com.E3N.head.first.OOAD.domain.v2.storeinstrument.enumerates.TypeInstrument;
import com.E3N.head.first.OOAD.domain.v2.storeinstrument.instrumentSpecs.InstrumentSpec;

public class Instrument {

    private final double price;
    private final String serialNumber;
    private final InstrumentSpec spec;

    private final TypeInstrument typeInstrument;

    public Instrument(double price, String serialNumber, InstrumentSpec spec, TypeInstrument typeInstrument) {
        this.price = price;
        this.serialNumber = serialNumber;
        this.spec = spec;
        this.typeInstrument = typeInstrument;
    }

    public double getPrice() {
        return price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }

    public TypeInstrument getTypeInstrument() {
        return typeInstrument;
    }

}
