package E3n.com.head.first.OOAD.domain.storeinstrument;

import E3n.com.head.first.OOAD.domain.storeinstrument.instruments.Instrument;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.InstrumentSpec;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Instrument> inventory = new ArrayList<>();

    public void addInstrument(final Instrument instrument){
        this.inventory.add(instrument);
    }

    public <T extends InstrumentSpec> List<Instrument> search(final InstrumentSpec  spec){
        List<Instrument> list = inventory.stream().filter(it -> it.getSpec().equals(spec)).toList();
        return list;
    }

    public Instrument getInstrument(final String serialNumber) {
        return inventory.stream().filter(it -> it.getSerialNumber().equals(serialNumber)).findFirst().orElse(null);
    }

    public List<Instrument> getInventory() {
        return inventory;
    }
}
