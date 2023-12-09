package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.FiddleSpec;

public class Fiddle extends Instrument{
    public Fiddle(String serialNumber, double price, FiddleSpec spec, WhoTune tune) {
        super(serialNumber, price, spec, tune);
    }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }

}