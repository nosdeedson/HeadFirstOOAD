package E3n.com.head.first.OOAD.domain.storeinstrument.instruments;

import E3n.com.head.first.OOAD.domain.storeinstrument.enumerated.WhoTune;
import E3n.com.head.first.OOAD.domain.storeinstrument.instrumentspec.GuitarSpec;

public class Guitar extends Instrument {

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        super(serialNumber, price, spec);
    }

    public Guitar() {   }

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + super.getSerialNumber() + '\'' +
                ", price=" + super.getPrice() +
                ", spec=" + super.getSpec().toString() +
                '}';
    }

    @Override
    public String tune() {
        return "afinando " + this.getClass().getSimpleName();
    }

}
