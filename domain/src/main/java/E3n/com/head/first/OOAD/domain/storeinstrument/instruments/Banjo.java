package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.BanjoSpec;

public class Banjo extends Instrument{
    public Banjo(String serialNumber, double price, BanjoSpec spec, WhoTune tune) {
        super(serialNumber, price, spec, tune);
    }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }
}
