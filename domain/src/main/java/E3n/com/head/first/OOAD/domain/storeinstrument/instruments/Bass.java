package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.InstrumentSpec;

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
