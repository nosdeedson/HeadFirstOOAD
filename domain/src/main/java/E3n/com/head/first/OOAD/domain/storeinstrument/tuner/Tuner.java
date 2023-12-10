package E3n.com.head.first.OOAD.domain.storeinstrument.tuner;

import E3n.com.head.first.OOAD.domain.storeinstrument.instruments.Instrument;

public class Tuner {

    private Instrument instrument;

    public Tuner(Instrument instrument) {
        this.instrument = instrument;
    }

    public String tunning(){
        return this.instrument.tune();
    }
}
