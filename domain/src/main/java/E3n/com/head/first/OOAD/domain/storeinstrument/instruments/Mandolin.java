package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.MandolinSpec;

public class Mandolin extends Instrument{

    public Mandolin(String serialNumber, double price, MandolinSpec spec, WhoTune tune) {
        super(serialNumber, price, spec, tune);
    }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
