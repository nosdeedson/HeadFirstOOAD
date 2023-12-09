package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.InstrumentSpec;

public abstract class Instrument {
    private String serialNumber;
    private double price;
    private InstrumentSpec spec;

    private WhoTune tune;

    public Instrument() {
    }

    public Instrument(String serialNumber, double price, InstrumentSpec spec, WhoTune tune) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
        this.tune = tune;
    }

    public abstract String tune();

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }
}
