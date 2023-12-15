package E3n.com.head.first.OOAD.domain.v2.storeinstrument.inventory;

import E3n.com.head.first.OOAD.domain.v2.storeinstrument.instrumentSpecs.InstrumentSpec;
import E3n.com.head.first.OOAD.domain.v2.storeinstrument.instruments.Instrument;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Instrument> instruments = new ArrayList<>();

    public void addInstrument(final Instrument instrument){
        instruments.add(instrument);
    }

    public List<Instrument> search(final InstrumentSpec spec){
        List<Instrument> matches = new ArrayList<>();
        for (Instrument instrument: instruments){
            final var theSame = instrument.getSpec().equals(spec);
            if (theSame){
                matches.add(instrument);
            }
        }
        return matches;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }
}
