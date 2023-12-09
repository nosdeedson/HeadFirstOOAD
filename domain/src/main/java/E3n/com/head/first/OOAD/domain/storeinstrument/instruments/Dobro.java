package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.InstrumentSpec;

public class Dobro extends Instrument{
    public Dobro(String serialNumber, double price, InstrumentSpec spec, WhoTune tune) {
        super(serialNumber, price, spec, tune);
    }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
